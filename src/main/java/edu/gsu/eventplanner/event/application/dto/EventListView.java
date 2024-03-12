package edu.gsu.eventplanner.event.application.dto;

import edu.gsu.eventplanner.event.domain.Event;

import java.time.LocalDateTime;

public record EventListView(
        Long id,
        String eventName,
        String eventLocation,
        LocalDateTime eventHeldAt,
        Long maxJoinCount
) {
    public static EventListView from (Event event){
        return new EventListView(
                event.getId(),
                event.getEventName(),
                event.getEventLocation(),
                event.getEventHeldAt(),
                event.getMaxJoinCount()
        );
    }
}
