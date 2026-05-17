package com.expense.api;

import com.expense.api.dto.ExpenseDto;
import com.expense.services.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expenses")
@Tag(name = "Expenses", description = "Expense management endpoints")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new expense")
    public ExpenseDto addExpense(@RequestBody CreateExpenseRequest request) {
        var expense = expenseService.addExpense(
                request.amount(), request.description(), request.date(),
                request.categoryId(), request.userId()
        );
        return new ExpenseDto(expense.getExpenseId(), expense.getAmount(),
                expense.getDescription(), expense.getDate(), expense.getCategoryId(),
                expense.getUserId(), expense.isShared());
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all expenses of a user")
    public List<ExpenseDto> getUserExpenses(@PathVariable String userId) {
        return expenseService.getUserExpenses(userId).stream()
                .map(e -> new ExpenseDto(e.getExpenseId(), e.getAmount(),
                        e.getDescription(), e.getDate(), e.getCategoryId(),
                        e.getUserId(), e.isShared()))
                .collect(Collectors.toList());
    }

    record CreateExpenseRequest(double amount, String description, LocalDate date,
                                String categoryId, String userId) {}
}
