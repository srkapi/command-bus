package com.srkapi.user.command;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class RegisterResponse implements Serializable {
    private final String id;

    public RegisterResponse(String id) {
        this.id = id;
    }
}
