package com.enriqueibarraig.eventtracking.event.application;

import com.enriqueibarraig.eventracking.event.application.CreateEventCommand;
import com.enriqueibarraig.eventracking.event.application.CreateEventService;
import com.enriqueibarraig.eventracking.event.domain.Event;
import com.enriqueibarraig.eventracking.event.domain.EventType;
import com.enriqueibarraig.eventracking.event.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class CreateEventServiceTest {

    @Mock
    private EventRepository eventRepository;

    private CreateEventService createEventService;

    @BeforeEach
    void setUp() {
        this.createEventService = new CreateEventService(this.eventRepository);
    }

    @Test
    public void whenEventIsValid_thenSaveCorrectly() {

        final OffsetDateTime offsetDateTime = OffsetDateTime.now();

        CreateEventCommand eventCommand = new CreateEventCommand(
                "TASK 1",
                "DESCRIPTION FOR TASK 1",
                EventType.INFORMATION,
                offsetDateTime
        );

        when(eventRepository.save(any(Event.class))).thenReturn(new Event("TASK 1", "DESCRIPTION FOR TASK 1", EventType.INFORMATION, offsetDateTime));

        var event = this.createEventService.execute(eventCommand);

        assertThat(event.getName()).isNotNull();

    }
}
