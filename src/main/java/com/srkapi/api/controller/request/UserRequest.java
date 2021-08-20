package com.srkapi.api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public final class UserRequest {
    private final String name;
    private final String email;
}
