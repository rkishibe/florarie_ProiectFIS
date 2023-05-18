package com.example.florarie_proiect.exceptions;

public class UserDoesNotExist extends Throwable {
    String username;

    public UserDoesNotExist(String username) {
        super(String.format("An account with the username %s does not exist!", username));
        this.username = username;
    }
}
