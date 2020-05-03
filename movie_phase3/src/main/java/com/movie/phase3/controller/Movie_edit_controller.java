package com.movie.phase3.controller;


import com.movie.phase3.Repository.*;
import com.movie.phase3.module.Login;
import com.movie.phase3.module.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
//@RequestMapping("/movies")
public class Movie_edit_controller {
    //MovieRepository movieRepo = new MovieRepository();
   private final moviejdbc jdbcRepos ;
   private final reviewJdbc jdbcreview;
   private final actorjdbc actorsview;
   private final Castjdbc castjdbc;
   private  final Userjdbc userjdbc;

   private Movie Movie_to_edit=null;
    @Autowired
    public Movie_edit_controller(Userjdbc userjdbc , moviejdbc jdbcRepos, Castjdbc castjdbc , reviewJdbc jdbcreview, actorjdbc actorsview)
    {
        this.jdbcRepos= jdbcRepos;
        this.jdbcreview= jdbcreview;
        this.actorsview= actorsview;
        this.castjdbc=castjdbc;
        this.userjdbc= userjdbc;
    }



    // show all movie for the admin with the ability to apply any CRUD operation on any movie
    @GetMapping("/manageMovies")
    public String manageMovies(@RequestParam(name ="sort" , required = false, defaultValue = "movie_title") String sort, Model model){
        model.addAttribute("movie", jdbcRepos.findAll(sort));
        // get all possible category from the database to display all possible filterations
        model.addAttribute("genre", jdbcRepos.Allgenre());
        model.addAttribute("login", new Login());
        model.addAttribute("user", UserController.user);
        Movie_to_edit = new Movie();
        model.addAttribute("newMovie", Movie_to_edit);

        return "admin/manageMovies";
    }



/**** movie adding mapping  process *****/




// admin show  add a new movie form
@GetMapping("/addMovie")
public String addMovie(Model model){
    Movie movie= new Movie();
    // ArrayList<Integer> movie_cast= new ArrayList<>();
    model.addAttribute("newMovie", movie);
    // model.addAttribute("user", UserController.user);
    model.addAttribute("allactors", actorsview.findAll("actor_id"));
    // model.addAttribute("actorList", movie_cast);

    return "admin/addMovie";
}
    // apply add movie operation to the database
    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie, @RequestParam(name ="cast" , required = false, defaultValue = "0,") String cast){
        ArrayList<Integer> movie_cast= new ArrayList<>();
        for (String val:cast.split(",")
        ) {
            movie_cast.add(Integer.parseInt(val));
        }

        jdbcRepos.add(movie, movie_cast);
        return "redirect:/manageMovies";
    }
// diplay added movie after admin finish filling the form



        /**** end of add movie process ****/


        /**edit and delete process **/
        // delete a movie and then display the updated list
@GetMapping("/deletemovie")
    public String delete_movie(@RequestParam(name ="id" , required = true, defaultValue = "0")int id){

      jdbcRepos.deletebyMovie_id(id);
        return "redirect:/manageMovies";
}
    // edit a movie and then display the updated list

    @PostMapping("/editmovie")
    public String editMovie(@ModelAttribute Movie movie, @RequestParam(name ="id" , required = false, defaultValue = "1")int id){

        movie.setMovie_id(id);
        jdbcRepos.updateMovie(movie);

        return ("redirect:/manageMovies");
    }
/**end of delete and edit process **/

}
