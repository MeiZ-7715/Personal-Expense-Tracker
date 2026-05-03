package com.expense.creational;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BudgetAlertServiceTest {
    @Test
    void testEmailAlertService() {
        BudgetAlertService service = new EmailBudgetAlertService();
        assertNotNull(service.createAlertSender());
        service.notifyUser("Budget warning", "user@example.com");
    }
    @Test
    void testSMSAlertService() {
        BudgetAlertService service = new SMSBudgetAlertService();
        assertNotNull(service.createAlertSender());
        service.notifyUser("Budget warning", "+27123456789");
    }
}
