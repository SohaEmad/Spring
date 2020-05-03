package com.movie.phase3.Repository;

import com.movie.phase3.module.Movie;

public interface moviejdbc {
    Iterable<Movie> findAll(String sort);
    Iterable<Movie> findAll();
    Movie findByid(int id);
    Iterable<String> Allgenre();
    Iterable<Movie> MoviesBygenre(String genre);
    public boolean exist(int id);
    void add (Movie movie, Iterable<Integer> actors);
   // Iterable<Actor> findCast(int movie_id);
    void deletebyMovie_id(int Movie_id);
    void updateMovie(Movie M);

}
