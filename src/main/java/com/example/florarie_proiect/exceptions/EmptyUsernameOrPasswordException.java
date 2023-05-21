package com.example.florarie_proiect.exceptions;

public class EmptyUsernameOrPasswordException extends Exception{
    public EmptyUsernameOrPasswordException() {
        super(String.format("Username or password cannot be empty!"));
    }
}
