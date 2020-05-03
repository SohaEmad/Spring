package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class greetingcontroller {


    private ArrayList<String> all = new ArrayList<String>();

    String[] continents = {
            "Africa", "Antarctica", "Asia", "Australia",
            "Europe", "North America", "Sourth America"
    };

    Greeting greeting;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        greeting = new Greeting();
        model.addAttribute("greeting", greeting);
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(Model modle ) {
    //    greeting.setData(allClientsWithSelection);#

     //   greeting.setData(all);
        modle.addAttribute("greeting", greeting);

        modle.addAttribute("continents", continents);
        return "result";
    }
    @RequestMapping("/crud")
    public String crud_process(Model modle) {
        //    greeting.setData(allClientsWithSelection);#

        //   greeting.setData(all);
        modle.addAttribute("greeting", greeting);
        return "crud";
    }




}