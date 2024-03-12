package edu.gsu.eventplanner.member.domain.exception;

public class NotFoundMemberException extends RuntimeException{
    public NotFoundMemberException(){
        super("No member data");
    }
}
