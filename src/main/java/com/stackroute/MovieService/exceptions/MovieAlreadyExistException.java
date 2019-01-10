package com.stackroute.MovieService.exceptions;

public class MovieAlreadyExistException extends Exception{
    String message;

    public MovieAlreadyExistException() {
    }

    public MovieAlreadyExistException(String messasge) {
        super(messasge);
        this.message = messasge;
    }
}
