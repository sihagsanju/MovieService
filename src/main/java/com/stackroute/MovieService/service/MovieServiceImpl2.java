package com.stackroute.MovieService.service;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieService.exceptions.MovieNotFoundException;
import com.stackroute.MovieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
@Qualifier("movieserviceimpl2")
public class MovieServiceImpl2 implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistException {

        return null;
    }
    @Override
    public List<Movie> getAllMovie() {
        return null;
    }

    @Override
    public boolean deleteMovie(int movieId)throws MovieNotFoundException {

        return false;
    }

    @Override
    public Movie getBymovieName( String moviename) {

        return null;
    }
    @Override
    public Movie UpdateMovie(Movie movie) throws MovieNotFoundException{

        return null;
    }
    @Override
    public Movie getMovieById(int movieId) {
        return null;
    }

}
