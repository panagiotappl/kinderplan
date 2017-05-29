package com.webapplication.error.user;

public enum UserRegisterError {
    MISSING_DATA("Required attributes are missing."),
    MISSING_EMAIL("Email is missing."),
    MISSING_PASSWORD("Password is missing."),
    MISSING_REPASSWORD("Repeat password is missing"),
    MISSING_NAME("Name is missing."),
    MISSING_SURNAME("Surname is missing."),
    MISSING_ROLE("Role is missing."),
    MISSING_ADDRESS("Address is missing."),
    PASSWORDS_NOT_MATCH("The password is not matched with re-password"),
    INVALID_DATA("Invalid data."),
    EMAIL_ALREADY_USED("Email is already in use.");

    private final String description;

    UserRegisterError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
