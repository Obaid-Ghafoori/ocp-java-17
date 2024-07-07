package chapter_07.classes.bank_app.model;

import java.time.LocalDate;

public record BankCustomer( String customerId, String fullName, String email, LocalDate registrationDate) {
}
