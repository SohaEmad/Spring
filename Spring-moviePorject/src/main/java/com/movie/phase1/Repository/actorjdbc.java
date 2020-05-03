package com.movie.phase1.Repository;

import com.movie.phase1.module.Actor;

public interface actorjdbc {
    Iterable<Actor> findAll();
    Iterable<Actor> findBygender(String gender);
    Iterable<Actor> findByname(String actor_name);
    Actor findBYid(int id);
    void add(Actor actor);

    //Iterable<movies> findmovies(int id);
}
