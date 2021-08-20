package com.srkapi.user.command;

import com.srkapi.shared.command.Command;

public class RegisterUserCommand implements Command<RegisterResponse> {
    private final String name;
    private final String email;

    public RegisterUserCommand(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
