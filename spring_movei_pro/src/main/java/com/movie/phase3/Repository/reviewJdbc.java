package com.movie.phase3.Repository;


import com.movie.phase3.module.Review;

public interface reviewJdbc {
    Iterable<Review> findAll();
    Iterable<Review> findBymovie(int movie_id);
    Iterable<Review> findByuser(int user_id);
    void addreview(Review review);

}
