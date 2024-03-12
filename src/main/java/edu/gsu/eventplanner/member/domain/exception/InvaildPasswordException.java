package edu.gsu.eventplanner.member.domain.exception;

public class InvaildPasswordException extends RuntimeException{
    public InvaildPasswordException(){
        super("password is wrong ");
    }
}
