package com.ticket.ticket.repository;

import com.ticket.ticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event , Integer> {
    List<Event> findByEventType(String eventType);
}
