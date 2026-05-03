package com.expense.model;

import java.util.UUID;

public class Category {
    private String categoryId;
    private String name;
    private String type;
    private boolean isActive;

    public Category(String name, String type) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.isActive = true;
    }

    public String getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public void createCustom() { this.type = "custom"; }
    public void deactivate() { this.isActive = false; }
    public void delete() { System.out.println("Category deleted: " + name); }
}
