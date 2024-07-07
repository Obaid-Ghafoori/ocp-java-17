package chapter_07.classes.bank_app.model;

import java.time.LocalDateTime;

public record Transaction(String transactionId, double amount, LocalDateTime timestamp) {
}
