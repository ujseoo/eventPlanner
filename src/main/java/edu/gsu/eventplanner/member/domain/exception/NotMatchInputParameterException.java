package edu.gsu.eventplanner.member.domain.exception;

public class NotMatchInputParameterException extends RuntimeException {
    public NotMatchInputParameterException() {
        super("input information do not match");
    }
}
