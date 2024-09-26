package com.example;

public class PasswordValidator {
    // The password must be at least 8 characters long.
    //The password must contain at least one uppercase letter.
    private NotificationService notificationService;


    public PasswordValidator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public boolean isValidPassword(String password){
        if( password == null || password.length() < 8 )
            return false;
            boolean valid = password.chars().anyMatch(Character::isUpperCase);
        if(valid){
            notificationService.sendNotification("Password is correct.");
        }
        return valid;
    }
}





