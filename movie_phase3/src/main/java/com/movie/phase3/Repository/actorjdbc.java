package com.movie.phase3.Repository;

import com.movie.phase3.module.Actor;

public interface actorjdbc {
    Iterable<Actor> findAll(String sort);
    Iterable<Actor> findBygender(String gender);
    Iterable<Actor> findByname(String actor_name);
    Actor findBYid(int id);
    void add(Actor actor);
    void edit (Actor actor);
    void delete(int id);
    //Iterable<movies> findmovies(int id);
}
