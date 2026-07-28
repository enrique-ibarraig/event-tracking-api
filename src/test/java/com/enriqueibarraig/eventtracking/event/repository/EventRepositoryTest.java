package com.enriqueibarraig.eventtracking.event.repository;

import com.enriqueibarraig.event.domain.EventType;
import com.enriqueibarraig.event.entity.EventEntity;
import com.enriqueibarraig.event.repository.EventRepository;
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
    public void whenNameIsNull_thenThrowError() {
        assertThatThrownBy(() -> {
            var entity = new EventEntity(null, null, null, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNameIsBlank_thenThrowError( ) {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("", null, null, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNameIsMoreThan100_thenThrowError( ) {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("AssertJ makes unit testing easy. You can write fluent assertions to check exceptions in your code.", null, null, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventTypeIsNull_thenThrowError( ) {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("ISSUE 1", null, null, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventDescriptionIsNull_thenThrowError() {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("ISSUE 1", EventType.INFORMATION, null, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventDescriptionIsBlank_thenThrowError() {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("ISSUE 1", EventType.INFORMATION, "", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventDescriptionIsMoreThan500_thenThrowError() {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("ISSUE 1", EventType.INFORMATION, "The AssertJ library provides a fluent interface for writing assertions in Java unit tests. When testing code that should fail under certain conditions, developers use the assertThatThrownBy method. This allows them to cleanly capture an exception thrown by a lambda expression and then chain multiple verifications together. For example, you can check the exception class type, verify the exact error message, or inspect the underlying cause. It makes test suites much more readable and easier to maintain.", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventOccurredIsNull_thenThrowError() {
        assertThatThrownBy(() -> {
            var entity = new EventEntity("ISSUE 1", EventType.INFORMATION, "ISSUE TASK 1", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenEventIsValid_thenCreateANewEvent() {
        var entity = new EventEntity("ISSUE 1", EventType.INFORMATION, "ISSUE TASK 1", OffsetDateTime.now());
        var entitySaved = this.repository.save(entity);

        assertThat(entitySaved.getId()).isEqualTo(1L);
    }
}
