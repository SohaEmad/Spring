package com.movie.phase3.controller;

import com.movie.phase3.Repository.Castjdbc;
import com.movie.phase3.Repository.actorjdbc;
import com.movie.phase3.module.Actor;
import com.movie.phase3.module.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Actor_Edit_controller {
    private final actorjdbc actorsview;
    private final Castjdbc castjdbc;

    @Autowired
    public Actor_Edit_controller(actorjdbc actorsview, Castjdbc castjdbc) {
        this.actorsview = actorsview;
        this.castjdbc = castjdbc;
    }
    // view all actors for any user
    @GetMapping("/ManageActors")
    public String Actor_Manageall(Model model, @RequestParam(name = "sort", required = false,defaultValue = "actor_id")String sort){
        model.addAttribute("all_actor",actorsview.findAll(sort) );
        model.addAttribute("login", new Login());
        model.addAttribute("user", UserController.user);
        Actor actor_to_edit = new Actor();
        model.addAttribute("newActor", actor_to_edit);
        return "admin/adminAllActors";

    }


    /**edit and delete process **/
    // delete a movie and then display the updated list
    @GetMapping("/deleteactor")
    public String delete_movie( @RequestParam(name ="id" , required = true, defaultValue = "0")int id){

        actorsview.delete(id);
        return "redirect:/ManageActors";
    }
    // edit a movie and then display the updated list

    @PostMapping("/editactor")
    public String editMovie(@ModelAttribute Actor actor, @RequestParam(name ="id" , required = false, defaultValue = "1")int id){

        actor.setActor_id(id);
        actorsview.edit(actor);

        return ("redirect:/ManageActors");
    }
    /**end of delete and edit process **/



// admin show  add a new movie form
    @GetMapping("/addActor")
    public String addActor(Model model){
        Actor actor= new Actor();
        model.addAttribute("newActor", actor);
        return "admin/addActor";
    }
    // apply add movie operation to the database
    @PostMapping("/addActor")
    public String addActor(@ModelAttribute Actor actor, @RequestParam(name ="cast" , required = false, defaultValue = "0,")String cast){

        actorsview.add(actor);
        return "redirect:/ManageActors";
    }



}
