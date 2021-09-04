package com.zbo.gql.gql.events;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class EventService {

    private static final Map<UUID, EventResponse> events = new HashMap<>();

    public EventResponse createEvent(EventInput eventInput) {
        var uuid = UUID.randomUUID();
        var eventResponse = new EventResponse(uuid, eventInput.getName(), eventInput.getDate());
        events.put(uuid, eventResponse);

        return eventResponse;
    }

    public Collection<EventResponse> findAll() {
        return events.values();
    }

    public EventResponse update(UUID id, EventInput input) {
        EventResponse event = events.get(id);
        if (event == null) {
            return null;
        }

        event.setName(input.getName());
        event.setDate(input.getDate());

        return event;
    }
}
