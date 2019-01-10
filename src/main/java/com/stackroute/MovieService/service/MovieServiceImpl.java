package com.stackroute.MovieService.service;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieService.exceptions.MovieNotFoundException;
import com.stackroute.MovieService.repository.MovieRepository;
//import jdk.internal.util.xml.impl.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
//@Qualifier("first")
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER= LogManager.getLogger(MovieServiceImpl.class);
    MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie( Movie movie) throws MovieAlreadyExistException {
        //return null;
        if(movieRepository.existsById(movie.getId()))
            throw new MovieAlreadyExistException();
            Movie savedmovie = movieRepository.save(movie);
            LOGGER.info("hii");
            return savedmovie;
    }
    @Override
    public List<Movie> getAllMovie() {
        //return null;
      //  List<Movie> allmovie=movieRepository.findAll();
        return movieRepository.findAll();}

    @Override
    public boolean deleteMovie(int movieId)throws MovieNotFoundException {
        //return false;
        if (!movieRepository.existsById(movieId))
         throw new MovieNotFoundException("movie Id is not there");
            movieRepository.deleteById(movieId);
            return true;
    }

    @Override
    public Movie getBymovieName(String moviename) throws MovieNotFoundException {
        if(movieRepository.existsBymovieName(moviename)) {
            Movie movietitle = movieRepository.getBymovieName(moviename);
            return movietitle;
            // return null;
        }
        else
            throw new MovieNotFoundException("movie Not present with this name");
    }

    // @Override
   // public Movie getBymovieName( String moviename) throws MovieNotFoundException {
        //return null;
//        String firstName = moviename;
//        Example<Movie> example = Example.of(new Movie(movieId,firstName));
//       Iterable<Movie> desiredmovie= movieRepository.findAll(example);
//        return desiredmovie;

//        ArrayList<Movie> movieData=new ArrayList<>();
//
//        for(int i=0;i<movieRepository.count();i++){
//
//            Movie movie=movieRepository.getOne(i);
//
//            if(movie.getMovieName().toLowerCase().trim().equalsIgnoreCase(moviename)){
//
//
//                movieData.add(movie);
//
//                if(i==movieRepository.count()-1){
//
//                    return movieData;
//                }
//            }
//        }

    @Override
    public Movie UpdateMovie(Movie movie) throws MovieNotFoundException{

       // movieRepository.findById(movie.movieId);
        if(movieRepository.existsById(movie.getId())==false) {
            throw new MovieNotFoundException("Movie  Id is not present");

        }
        Movie movie1=movieRepository.findById(movie.getId()).get();
            movie1.setId(movie.getId());
            movie1.setMovieName(movie.getMovieName());
            return movieRepository.save(movie1);

    }

    @Override
    public Movie getMovieById(int movieId) {
        return null;
    }
}
