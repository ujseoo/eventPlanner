package edu.gsu.eventplanner.event.domain.exception;

public class NotFoundEventException extends RuntimeException{
    public NotFoundEventException(){
        super("No event information");
    }
}
