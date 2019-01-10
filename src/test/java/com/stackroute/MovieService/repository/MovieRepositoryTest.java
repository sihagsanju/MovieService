package com.stackroute.MovieService.repository;

import com.stackroute.MovieService.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MovieRepositoryTest {
        @Autowired
        MovieRepository movieRepository;
        Movie movie;

        @Before
        public void setUp() throws Exception {
            movie=new Movie();
            movie.setId(101);
            movie.setMovieName("Conjuring");

        }

    @After
    public void tearDown() {
        movieRepository.deleteAll();
    }

    @Test
        public void testSaveMovie(){
            movieRepository.save(movie);
            Movie fetchMovie = movieRepository.findById(movie.getId()).get();
            Assert.assertEquals(101,fetchMovie.getId());

        }
        @Test
        public void testSaveMovieFailure(){
            Movie testmovie = new Movie(15,"Harry");
            movieRepository.save(movie);
            Movie fetchMovie =movieRepository.findById(movie.getId()).get();
            Assert.assertNotSame(movie,fetchMovie);
        }
        @Test
        public void testGetAllMovie()
        {
            Movie movie1=new Movie(12,"Fast& Furious");
            Movie movie2=new Movie(11,"movie2");
            movieRepository.save(movie1);
            movieRepository.save(movie2);
            List<Movie> list=movieRepository.findAll();
            System.out.println(list.size()+"the size is");
            Assert.assertEquals("Fast& Furious",list.get(0).getMovieName());
        }
        @Test
       public void testGetByNameTest()
        {
            movieRepository.save(movie);
            Movie movie1=movieRepository.findById(movie.getId()).get();
            Assert.assertEquals("Conjuring",movie1.getMovieName() );

        }
        @Test
        public void testUpdateMovie()
        {
            Movie movie1= movieRepository.save(movie);
            movie1.setMovieName("spiderman");
            Assert.assertEquals(movie1, new Movie(movie.getId(),"spiderman"));
            System.out.println(movie1.hashCode());
            System.out.println(movie.hashCode());
        }
        @Test
        public void testUpdateFailure()
        {
            Movie movie1= movieRepository.save(movie);
            movie1.setMovieName("spiderman");
            movie1.getId();
           // Assert.assertEquals(movie1, new Movie(movie.getId(),"spiderman"));
            System.out.println(movie1.hashCode());
            System.out.println(movie.hashCode());
           Movie fetchMovie =movieRepository.findById(movie.getId()).get();
            Assert.assertNotSame(movie1,fetchMovie);
        }
        @Test
        public void testDeleteMovie()
        {
           Movie movie1=movieRepository.save(movie);
            Movie movie2=movieRepository.getBymovieName(movie1.getMovieName());
            movieRepository.deleteById(movie.getId());
            Movie movie3=movieRepository.getBymovieName(movie2.getMovieName());
            System.out.println(movie2);
            System.out.println(movie3);
            Assert.assertEquals(null,movie3);
        }
        @Test
        public void testDeleteFailure()
        {
           Movie movie1= movieRepository.save(movie);
            Movie movie2 = movieRepository.getBymovieName(movie1.getMovieName());
           movieRepository.deleteById(movie.getId());
            Assert.assertNotSame(movie1,movie2);
        }
        @Test
        public void testGetMovieByName()
        {

        }

    }
