package com.enriqueibarraig.eventracking.event.application;

import com.enriqueibarraig.eventracking.event.domain.EventType;

import java.time.OffsetDateTime;

public record CreateEventCommand(
        String name,
        String description,
        EventType eventType,
        OffsetDateTime occurredAt
) { }
