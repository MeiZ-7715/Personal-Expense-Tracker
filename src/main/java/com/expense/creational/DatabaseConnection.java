package com.expense.creational;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private DatabaseConnection() { System.out.println("DatabaseConnection created"); }
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) instance = new DatabaseConnection();
        return instance;
    }
    public void connect() { System.out.println("Connected to database"); }
    public void disconnect() { System.out.println("Disconnected"); }
}
