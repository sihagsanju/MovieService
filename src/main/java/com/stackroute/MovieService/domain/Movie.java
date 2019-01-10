package com.stackroute.MovieService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Document
public class Movie {
    @Id
    public int id;
    @NotNull
    public String movieName;

    public Movie() {
    }

    public Movie(int movieId, String movieName) {
        this.id = movieId;
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + id +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(movieName, movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieName);
    }
}
