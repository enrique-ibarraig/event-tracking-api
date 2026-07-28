package com.enriqueibarraig.event.entity;

import com.enriqueibarraig.event.domain.EventType;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity()
@Table(name = "events")
public class EventEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, length = 50)
    private EventType eventType;

    @Column(name = "occurred_at", nullable = false)
    private OffsetDateTime occurredAt;

    @Column(name = "created_at", insertable = false, nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    protected EventEntity() {}

    public EventEntity(
            String name,
            EventType eventType,
            String description,
            OffsetDateTime occurredAt
    ) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Event name must not be blank");
        }

        if (name.length() > 100) {
            throw new IllegalArgumentException("Event name must not be more than 100 characters");
        }

        if (Objects.isNull(eventType)) {
            throw new IllegalArgumentException("Event type must not be null");
        }

        if (Objects.isNull(occurredAt)) {
            throw new IllegalArgumentException("Event occurred must not be null");
        }

        if (Objects.isNull(description) || description.isBlank()) {
            throw new IllegalArgumentException("Event description must not be blank");
        }

        if (description.length() > 500) {
            throw new IllegalArgumentException("Event description must not be more than 500 characters");
        }

        this.name = name;
        this.eventType = eventType;
        this.description = description;
        this.occurredAt = occurredAt;
    }

}
