package edu.gsu.eventplanner.event.domain.exception;

public class NotMyEventException extends RuntimeException{
    public NotMyEventException(){
        super("This is not an event you created");
    }
}
