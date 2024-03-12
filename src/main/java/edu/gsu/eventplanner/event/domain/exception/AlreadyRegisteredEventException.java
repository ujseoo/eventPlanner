package edu.gsu.eventplanner.event.domain.exception;

public class AlreadyRegisteredEventException extends RuntimeException{
    public  AlreadyRegisteredEventException(){
        super("Already Registered event");
    }
}
