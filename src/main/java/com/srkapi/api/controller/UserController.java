package com.srkapi.api.controller;

import com.srkapi.api.controller.request.UserRequest;
import com.srkapi.shared.command.CommandBus;
import com.srkapi.shared.query.QueryBus;
import com.srkapi.user.command.RegisterResponse;
import com.srkapi.user.command.RegisterUserCommand;
import com.srkapi.user.query.GetUserByIdQuery;
import com.srkapi.user.query.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;


    @PostMapping("/user")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest) throws Exception {

        RegisterUserCommand registerUserCommand = new RegisterUserCommand(userRequest.getName(), userRequest.getEmail());

        RegisterResponse dispatch = this.commandBus.dispatch(registerUserCommand);

        return ResponseEntity.ok(dispatch);

    }

    @GetMapping("/user")
    public ResponseEntity getUserById() throws Exception {

        GetUserByIdQuery query = new GetUserByIdQuery(UUID.randomUUID().toString());
        ResponseUser result = queryBus.dispatch(query);

        return ResponseEntity.ok(result);
    }
}
