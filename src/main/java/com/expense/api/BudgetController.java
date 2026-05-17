package com.expense.api;

import com.expense.api.dto.BudgetDto;
import com.expense.services.BudgetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/budgets")
@Tag(name = "Budgets", description = "Budget management endpoints")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Set or update a monthly budget")
    public BudgetDto setBudget(@RequestBody SetBudgetRequest request) {
        var budget = budgetService.setBudget(
                request.categoryId(), request.userId(), request.month(), request.amountLimit()
        );
        return new BudgetDto(budget.getBudgetId(), budget.getCategoryId(),
                budget.getUserId(), budget.getMonth(), budget.getAmountLimit(),
                budget.getSpentAmount());
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "Get all budgets of a user")
    public List<BudgetDto> getUserBudgets(@PathVariable String userId) {
        return budgetService.getBudgetsByUser(userId).stream()
                .map(b -> new BudgetDto(b.getBudgetId(), b.getCategoryId(),
                        b.getUserId(), b.getMonth(), b.getAmountLimit(), b.getSpentAmount()))
                .collect(Collectors.toList());
    }

    record SetBudgetRequest(String categoryId, String userId, String month, double amountLimit) {}
}
