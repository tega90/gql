package com.zbo.gql.gql.events;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EventController implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final EventService eventService;
    private final EventPublisher eventPublisher;

    public Collection<EventResponse> events() {
        return eventService.findAll();
    }

    public EventResponse createEvent(EventInput event) {

        var createdEvent = eventService.createEvent(event);
        eventPublisher.publish(createdEvent);
        return createdEvent;
    }

    public EventResponse updateEvent(UUID id, EventInput input) {
        EventResponse updatedEvent = eventService.update(id, input);
        eventPublisher.publish(updatedEvent);
        return updatedEvent;
    }
}
