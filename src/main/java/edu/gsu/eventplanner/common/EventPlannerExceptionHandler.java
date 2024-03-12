package edu.gsu.eventplanner.common;

import edu.gsu.eventplanner.common.response.EventPlannerResponse;
import edu.gsu.eventplanner.event.domain.exception.ExistedEventException;
import edu.gsu.eventplanner.event.domain.exception.NotFoundEventException;
import edu.gsu.eventplanner.event.domain.exception.NotMyEventException;
import edu.gsu.eventplanner.event.domain.exception.NotRegisteredEventException;
import edu.gsu.eventplanner.member.domain.exception.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.AlreadyBoundException;
import java.util.List;

@RestControllerAdvice
public class EventPlannerExceptionHandler {
    @ExceptionHandler({

            InvaildPasswordException.class,
            NotAuthorizedException.class,
            NotFoundMemberException.class,

    })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public EventPlannerResponse<String> handleAuthorized(Exception exception){
        return new EventPlannerResponse<>(exception.getMessage(),HttpStatus.UNAUTHORIZED.value());

    }
    @ExceptionHandler({
            ExistedMemberException.class,
            NotMatchInputParameterException.class,
            AlreadyBoundException.class,
            ExistedEventException.class,
            NotFoundEventException.class,
            NotMyEventException.class,
            NotRegisteredEventException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EventPlannerResponse<String> handleBadRequest(Exception exception){
        return new EventPlannerResponse<>(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EventPlannerResponse<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception){
        List<String> errorMessages = exception.getBindingResult()
                .getFieldErrors()
                .stream().
                map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        return new EventPlannerResponse<>(errorMessages, HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Throwable.class)
    public void handleRest(Throwable throwable) throws Throwable {
        throw throwable;

    }
}
