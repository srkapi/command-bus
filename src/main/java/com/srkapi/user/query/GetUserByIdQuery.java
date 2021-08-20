package com.srkapi.user.query;

import com.srkapi.shared.query.Query;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetUserByIdQuery implements Query<ResponseUser> {
    private String id;
}
