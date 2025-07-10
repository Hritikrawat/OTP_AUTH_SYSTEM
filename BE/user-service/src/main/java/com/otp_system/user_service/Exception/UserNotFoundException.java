package com.otp_system.user_service.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mobile){
        super("User not found for mobile number : "+mobile);

    }
}
