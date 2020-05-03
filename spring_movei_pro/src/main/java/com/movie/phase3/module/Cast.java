package com.movie.phase3.module;

import lombok.Data;

@Data
public class Cast {
    private int movie_cast_id;
    private int movie_id;
    private int actor_id;

    public int getMovie_id(){
        return movie_id;
    }
}
