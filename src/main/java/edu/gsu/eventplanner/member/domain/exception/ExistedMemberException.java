package edu.gsu.eventplanner.member.domain.exception;

public class ExistedMemberException extends RuntimeException{
    public ExistedMemberException(){
        super("Already Registered ");
    }
}
