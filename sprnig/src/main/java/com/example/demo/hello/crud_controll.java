package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class crud_controll {


    Greeting g= new Greeting();
    @RequestMapping(value = "/delet_person", method = RequestMethod.GET)
    public String handleDeleteUser() {
        System.out.println(personId);
        System.out.println("test");
        g.getData().remove(personId);

        return "crud";
    }

}
