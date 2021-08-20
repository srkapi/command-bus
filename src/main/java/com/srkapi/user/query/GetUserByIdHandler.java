package com.srkapi.user.query;

import com.srkapi.shared.autoscan.QueryMapping;
import com.srkapi.shared.query.QueryHandler;

@QueryMapping(value = GetUserByIdQuery.class)
public class GetUserByIdHandler implements QueryHandler<GetUserByIdQuery, ResponseUser> {
    @Override
    public ResponseUser handle(GetUserByIdQuery query) throws Exception {
        return new ResponseUser("kapi");
    }
}
