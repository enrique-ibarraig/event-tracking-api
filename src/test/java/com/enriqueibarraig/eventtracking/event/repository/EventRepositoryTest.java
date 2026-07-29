package com.enriqueibarraig.eventtracking.event.repository;

import com.enriqueibarraig.eventracking.event.domain.Event;
import com.enriqueibarraig.eventracking.event.domain.EventType;
import com.enriqueibarraig.eventracking.event.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.time.OffsetDateTime;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class EventRepositoryTest {

    @Autowired
    private EventRepository repository;

    @Test
    public void whenEventIsValid_thenCreateANewEvent() {
        var entity = new Event("ISSUE 1", EventType.INFORMATION, "ISSUE TASK 1", OffsetDateTime.now());
        var entitySaved = this.repository.save(entity);

        assertThat(entitySaved.getId()).isEqualTo(1L);
    }
}
