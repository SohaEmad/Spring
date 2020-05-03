package com.movie.phase1.controller;


import com.movie.phase1.Repository.Castjdbc;
import com.movie.phase1.Repository.actorjdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Actor_View_Controller {

    private final actorjdbc actorsview;
    private final Castjdbc castjdbc;

    @Autowired
    public Actor_View_Controller(actorjdbc actorsview, Castjdbc castjdbc) {
        this.actorsview = actorsview;
        this.castjdbc = castjdbc;
    }
// view all actors for any user
    @GetMapping("/viewActors")
    public String Actor_displayall(Model model){
        model.addAttribute("all_actor",actorsview.findAll() );
        return "user_views/Allactors";

    }
// view on actor profile by id for any user
    @GetMapping("/viewActorprofile")
    public String Actor_display(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model){
        model.addAttribute("actor",actorsview.findBYid(id) );
        model.addAttribute("movies",castjdbc.findmovies(id));
        return "user_views/Actor_profile";

    }
}
