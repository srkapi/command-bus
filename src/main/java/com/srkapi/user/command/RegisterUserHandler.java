package com.srkapi.user.command;

import com.srkapi.shared.autoscan.CommandMapping;
import com.srkapi.shared.command.CommandHandler;

import java.util.UUID;

@CommandMapping(value = RegisterUserCommand.class)
public class RegisterUserHandler implements CommandHandler<RegisterUserCommand, RegisterResponse> {

    @Override
    public RegisterResponse handle(RegisterUserCommand command) throws Exception {
        return new RegisterResponse(UUID.randomUUID().toString());
    }
}
