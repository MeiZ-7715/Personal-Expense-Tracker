package com.expense.model;

import java.util.UUID;

public class SharedExpense {
    private String shareId;
    private String expenseId;
    private String ownerId;
    private String sharedWithId;
    private String status;

    public SharedExpense(String expenseId, String ownerId, String sharedWithId) {
        this.shareId = UUID.randomUUID().toString();
        this.expenseId = expenseId;
        this.ownerId = ownerId;
        this.sharedWithId = sharedWithId;
        this.status = "pending";
    }

    public String getShareId() { return shareId; }
    public String getExpenseId() { return expenseId; }
    public String getOwnerId() { return ownerId; }
    public String getSharedWithId() { return sharedWithId; }
    public String getStatus() { return status; }

    public void invite() { System.out.println("Invitation sent to " + sharedWithId); }
    public void accept() { this.status = "accepted"; }
    public void reject() { this.status = "rejected"; }
}
