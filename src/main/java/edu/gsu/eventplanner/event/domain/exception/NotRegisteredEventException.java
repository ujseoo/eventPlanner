package edu.gsu.eventplanner.event.domain.exception;

public class NotRegisteredEventException extends RuntimeException{
    public NotRegisteredEventException(){
        super("It's an event that you don't request ");
    }
}
