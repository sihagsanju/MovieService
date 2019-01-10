package com.stackroute.MovieService.service;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieService.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException;
    public List<Movie> getAllMovie();
    public boolean deleteMovie(int movieId) throws MovieNotFoundException;
    public Movie getBymovieName(String moviename) throws MovieNotFoundException;
    public Movie UpdateMovie(Movie movie) throws MovieNotFoundException;
    public Movie getMovieById(int movieId);
}
