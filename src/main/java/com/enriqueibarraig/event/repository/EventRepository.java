package com.enriqueibarraig.event.repository;

import com.enriqueibarraig.event.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long > {
}
