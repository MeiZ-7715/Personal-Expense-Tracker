package com.expense.model;

import java.util.Date;
import java.util.UUID;

public class Alert {
    private String alertId;
    private String userId;
    private String budgetId;
    private String message;
    private Date triggeredAt;
    private String status;

    public Alert(String userId, String budgetId, String message) {
        this.alertId = UUID.randomUUID().toString();
        this.userId = userId;
        this.budgetId = budgetId;
        this.message = message;
        this.triggeredAt = new Date();
        this.status = "pending";
    }

    public String getAlertId() { return alertId; }
    public String getUserId() { return userId; }
    public String getBudgetId() { return budgetId; }
    public String getMessage() { return message; }
    public Date getTriggeredAt() { return triggeredAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void trigger() { this.status = "triggered"; System.out.println("Alert: " + message); }
    public void dismiss() { this.status = "dismissed"; }
    public void expire() { this.status = "expired"; }
}
