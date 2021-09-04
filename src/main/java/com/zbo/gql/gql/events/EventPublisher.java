package com.zbo.gql.gql.events;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

import java.util.UUID;

@Component
@Slf4j
public class EventPublisher {

    private final Sinks.Many<EventResponse> sink;

    public EventPublisher() {
        this.sink = Sinks.many().unicast().onBackpressureBuffer();
    }

    public Publisher<EventResponse> getEventPublisherFor(UUID id) {

        return sink.asFlux()
            .filter(event -> id.equals(event.getId()))
            .map(event -> {
                log.info("Publishing event with id {}", id);
                return event;
            });
    }

    public void publish(EventResponse createdEvent) {
        sink.emitNext(createdEvent, (signalType, emitResult) -> {
            log.error(signalType.toString());
            log.error(emitResult.toString());
            return false;
        });
    }

    public Publisher<EventResponse> getEventPublisher() {

        return sink.asFlux();
    }
}
