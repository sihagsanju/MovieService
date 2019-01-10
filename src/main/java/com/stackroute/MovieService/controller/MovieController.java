package com.stackroute.MovieService.controller;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.exceptions.MovieNotFoundException;
import com.stackroute.MovieService.service.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {
    private static final Logger LOGGER= LogManager.getLogger(MovieController.class);
    @Autowired
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping(value="movie")
    public ResponseEntity<?> getAllMovie()
    {
        System.out.println("in get all movies +++++++++====");
        return new ResponseEntity<List<Movie>>(movieService.getAllMovie(),HttpStatus.OK);
    }
    @PostMapping(value="movie")
    public ResponseEntity<?> saveMovie(@Valid @RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            LOGGER.info("Controller save method info");
            LOGGER.debug("Save method debug");
            responseEntity=new ResponseEntity<String>("Movie saved ", HttpStatus.CREATED);
        }
        catch(Exception ex)
        {
            LOGGER.error("Error : Movie alredy ");
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping(value="/getmovie/{name}")
    public ResponseEntity<?> getUser(@PathVariable("name") String username) throws MovieNotFoundException {
             try {
                 LOGGER.info("Controller getmovie by name info");
                 LOGGER.debug("getmovie by name debug");
                 System.out.println("inside movie by name");
                 return new ResponseEntity<Movie>(movieService.getBymovieName(username), HttpStatus.OK);
             }
             catch(MovieNotFoundException e)
             {
                 LOGGER.error("Movie not their Error");
                 return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
             }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMovie(@Valid @RequestBody Movie movie, @PathVariable int id) throws MovieNotFoundException {
        try {
            LOGGER.info("Controller update movie info");
            LOGGER.debug("update debug");
           Movie updatemovie= movieService.UpdateMovie(movie);
            return new ResponseEntity(updatemovie, HttpStatus.CREATED);
        }
        catch(MovieNotFoundException e)
        {
            LOGGER.error("Update Error");
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CREATED);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(Movie movie,@PathVariable int id) throws MovieNotFoundException {
        //  if()
        try {
            LOGGER.info("Controller Delete movie info");
            LOGGER.debug("delete debug start");
            movieService.deleteMovie(id);
            return new ResponseEntity<String>("Movie Deleted", HttpStatus.OK);
        } catch (MovieNotFoundException e) {
            LOGGER.error("Delete method Error");
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
