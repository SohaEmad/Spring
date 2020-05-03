package jbr.springmvc.controller;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class showall {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/showall", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("showall");
                //new ModelAndView("showall");
       // mav.addObject("login", new Login());

       List<User> users = userService.showAll();

      // for(User one:users){
           mav.addObject("alluser", users);
      // }



        return mav;
    }
}
