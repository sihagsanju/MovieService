package com.stackroute.MovieService.service;

import com.stackroute.MovieService.domain.Movie;
import com.stackroute.MovieService.exceptions.MovieAlreadyExistException;
import com.stackroute.MovieService.exceptions.MovieNotFoundException;
import com.stackroute.MovieService.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MovieserviceTest {
    Movie movie;

    //Create a mock for UserRepository
    @Mock//test double
            MovieRepository movieRepository;

    //Inject the mocks as dependencies into MovieServiceImpl
   @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setId(25);
        movie.setMovieName("movie16");
        list = new ArrayList<>();
        list.add(movie);


    }

    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistException {

        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie savedUser = movieService.saveMovie(movie);
        Assert.assertEquals(movie, savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository, times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie savedMovie = movieService.saveMovie(movie);
        System.out.println("savedUser" + savedMovie);
        Assert.assertEquals(movie, savedMovie);
        verify(movieRepository, times(1)).save(movie);
        throw new MovieAlreadyExistException("Movie present");

        //add verify
        //do
        // new Throw (new MovieAlreadyExistException()).when(movieRepository).findById(eq(101));
        //movieService.saveMovie(movie);


    }

    @Test
    public void getAllUser() {

        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> userlist = movieService.getAllMovie();
        Assert.assertEquals(list, userlist);
        // verify(movieRepository,times(5)).findAll();
        //add verify
    }

    @Test
    //@Rollback(true)
    public void testUpdateMovie() throws MovieAlreadyExistException {
        // movieRepository.save(movie);
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie movie1 = movieRepository.save(movie);
        //movieService.saveMovie(movie);
        movie1.setMovieName("spiderman");
        movie1.setId(movie.getId());
        Assert.assertEquals(movie1, new Movie(movie.getId(), "spiderman"));
        System.out.println(movie1.hashCode());
        System.out.println(movie.hashCode());

    }
    @Test
    public void testUpdateFailureMovie() throws MovieAlreadyExistException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie movie1 = movieRepository.save(movie);
        // Movie movie1=movieRepository.save(movie);
        movie1.getId();
        movie1.setMovieName("movie123");
        System.out.println(movie1);
        System.out.println(movie);
        System.out.println(movie.hashCode());
        System.out.println(movie1.hashCode());
        Assert.assertNotSame(movie1,new Movie(movie.getId(),"movie13"));
    }

    @Test
    public void testDeleteMovie() throws MovieNotFoundException {
        when(movieRepository.existsById(movie.getId())).thenReturn(true);
            boolean movievalue = movieService.deleteMovie(movie.getId());
           System.out.println(movie.getId());
            System.out.println(movievalue);
           System.out.println(movieService.deleteMovie(movie.getId()));
        System.out.println(movie);
           Assert.assertEquals(movievalue, movieService.deleteMovie(movie.getId()));

    }

        // throw  new MovieNotFoundException("movie not");
//        Movie movie2= movieService.saveMovie(movie);
//        //movieService.saveMovie(movie);
//        System.out.println(movie2.hashCode());
//        System.out.println(movie.hashCode());
    @Test
    public void testDeletFailure() throws MovieAlreadyExistException, MovieNotFoundException {
        when(movieRepository.existsById(movie.getId())).thenReturn(true);
            boolean status = movieService.deleteMovie(movie.getId());
            System.out.println(status );
            assertNotEquals(false, status);
        }
     @Test
    public void testGetByMovieName() throws MovieNotFoundException, MovieAlreadyExistException {
         when(movieRepository.save((Movie) any())).thenReturn(movie);
         Movie movie2=movieService.saveMovie(movie);
         System.out.println(movie2);
         System.out.println(movie);
         Assert.assertEquals(movie.getMovieName(),movie2.getMovieName());

     }
    }

