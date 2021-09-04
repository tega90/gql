package com.zbo.gql.gql.events;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EventSubscription implements GraphQLSubscriptionResolver {

    private final EventPublisher eventPublisher;

    public Publisher<EventResponse> events() {
        return eventPublisher.getEventPublisher();
    }

    public Publisher<EventResponse> event(UUID id) {
        return eventPublisher.getEventPublisherFor(id);
    }
}
