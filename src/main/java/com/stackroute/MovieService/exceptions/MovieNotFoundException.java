package com.stackroute.MovieService.exceptions;

public class MovieNotFoundException extends Exception{
   public String message;
    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
