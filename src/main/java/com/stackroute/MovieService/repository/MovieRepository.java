package com.stackroute.MovieService.repository;

import com.stackroute.MovieService.domain.Movie;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//public interface MovieRepository extends JpaRepository<Movie,Integer> {
public interface MovieRepository extends MongoRepository<Movie,Integer> {
  //  public Movie getBymovieName(String name);

  public Movie getBymovieName(String name);
  public boolean existsBymovieName(String name);
}
