package com.enriqueibarraig.eventracking.event.repository;

import com.enriqueibarraig.eventracking.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long > {
}
