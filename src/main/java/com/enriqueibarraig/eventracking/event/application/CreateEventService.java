package com.enriqueibarraig.eventracking.event.application;

import com.enriqueibarraig.eventracking.event.domain.Event;
import com.enriqueibarraig.eventracking.event.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class CreateEventService {

    private final EventRepository repository;

    public CreateEventService(EventRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Event execute(CreateEventCommand createEventCommand) {
        if (Objects.isNull(createEventCommand)) {
            throw new IllegalArgumentException(
                    "Create event command must not be null"
            );
        }

        Event event = new Event(
                createEventCommand.name(),
                createEventCommand.description(),
                createEventCommand.eventType(),
                createEventCommand.occurredAt()
        );

        return this.repository.save(event);
    }

}
