package com.srkapi.shared.autoscan;


import com.srkapi.shared.query.Query;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(QueryMappings.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryMapping {
    Class<? extends Query> value();
}