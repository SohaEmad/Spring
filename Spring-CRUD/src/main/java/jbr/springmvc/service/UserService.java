package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

import java.util.List;

public interface UserService {

  void register(User user);

  User validateUser(Login login);
   List<User> showAll();
}
