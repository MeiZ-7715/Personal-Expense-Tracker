package com.expense.creational;

interface AlertSender { void sendAlert(String message, String recipient); }

class EmailAlertSender implements AlertSender {
    public void sendAlert(String message, String recipient) { System.out.println("Email to " + recipient + ": " + message); }
}

class SMSAlertSender implements AlertSender {
    public void sendAlert(String message, String recipient) { System.out.println("SMS to " + recipient + ": " + message); }
}

public abstract class BudgetAlertService {
    public abstract AlertSender createAlertSender();
    public void notifyUser(String message, String recipient) {
        AlertSender sender = createAlertSender();
        sender.sendAlert(message, recipient);
    }
}

class EmailBudgetAlertService extends BudgetAlertService {
    public AlertSender createAlertSender() { return new EmailAlertSender(); }
}

class SMSBudgetAlertService extends BudgetAlertService {
    public AlertSender createAlertSender() { return new SMSAlertSender(); }
}
