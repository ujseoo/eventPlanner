package edu.gsu.eventplanner.member.domain.exception;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(){
        super("login information do not match");
    }
}
