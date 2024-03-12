package edu.gsu.eventplanner.event.domain.exception;

public class ExistedEventException extends RuntimeException{
    public ExistedEventException(){
        super("Already existed event");
    }
}
