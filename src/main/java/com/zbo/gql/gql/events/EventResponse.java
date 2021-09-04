package com.zbo.gql.gql.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    UUID id;
    String name;
    OffsetDateTime date;
}
