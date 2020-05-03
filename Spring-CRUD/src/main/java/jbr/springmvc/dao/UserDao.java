package jbr.springmvc.dao;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

import java.util.List;

public interface UserDao {

  void register(User user);

  User validateUser(Login login);
   List<User> showAll() ;
}
