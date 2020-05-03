package com.movie.phase1.Repository;

import com.movie.phase1.module.Login;
import com.movie.phase1.module.Review;
import com.movie.phase1.module.User;

public interface Userjdbc {

    Iterable<User> findAll();
    User findByID(int id);
   // String upatepass();
    void register(User user);
    User validateUser(Login login);


}
