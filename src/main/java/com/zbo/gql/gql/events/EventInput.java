package com.zbo.gql.gql.events;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class EventInput {
    private String name;
    private OffsetDateTime date;
}
