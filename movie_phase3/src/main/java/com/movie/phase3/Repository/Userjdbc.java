package com.movie.phase3.Repository;


import com.movie.phase3.module.Login;
import com.movie.phase3.module.User;

public interface Userjdbc {

    Iterable<User> findAll();
    User findByID(int id);
   // String upatepass();
    void register(User user);
    User validateUser(Login login);


}
