package edu.gsu.eventplanner.event.application.command;

import edu.gsu.eventplanner.event.domain.Event;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Getter

public class EventCreateCommand {

    private String eventName;
    private String eventLocation;
    private LocalDateTime eventHeldAt;
    private Long maxJoinCount;
    private String eventContents;
    private String accessToken;
    public Event execute(Long createdBy){
        return Event.createEvent(eventName,eventLocation,eventHeldAt,maxJoinCount,eventContents,createdBy);

    }

}
