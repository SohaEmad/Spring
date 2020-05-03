package com.movie.phase1.controller;

import com.movie.phase1.Repository.*;
import com.movie.phase1.module.Login;
import com.movie.phase1.module.Movie;
import com.movie.phase1.module.Review;
import com.movie.phase1.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Movie_view_controller {
    private final moviejdbc jdbcRepos ;
    private final reviewJdbc jdbcreview;
    private final actorjdbc actorsview;
    private final Castjdbc castjdbc;
    private  final Userjdbc userjdbc;

    private Movie Movie_to_edit=null;
    @Autowired
    public Movie_view_controller(Userjdbc userjdbc , moviejdbc jdbcRepos, Castjdbc castjdbc , reviewJdbc jdbcreview, actorjdbc actorsview)
    {
        this.jdbcRepos= jdbcRepos;
        this.jdbcreview= jdbcreview;
        this.actorsview= actorsview;
        this.castjdbc=castjdbc;
        this.userjdbc= userjdbc;
    }

    //first page on the application for all users
    @GetMapping("/")
    public String display (@RequestParam(name ="sort" , required = false, defaultValue = "movie_title")String sort, Model model, @ModelAttribute("user") User user){
//model.addAttribute("movies", movieRepo.getmovies(movieRepo.getDBConnetion()));
        //   List<movies> ingredients = Lists.newArrayList(jdbcRepos.findAll(sort));
        model.addAttribute("user", UserController.user);
        model.addAttribute("movie", jdbcRepos.findAll(sort));
        model.addAttribute("genre", jdbcRepos.Allgenre());
        model.addAttribute("login", new Login());
           if(null!=Movie_to_edit)
        Movie_to_edit = new Movie();
        model.addAttribute("newMovie", Movie_to_edit);

       return "index";
      //  return "admin/adminAllMovies";
    }

    // show a single movie detailed information by id for all users
    // allow logged in users to add reviews
    // anynoumus user have to log in to add review
    @GetMapping("/viewMovie")
    public String showamovie(@RequestParam(name ="id" , required = false, defaultValue = "1")int id, Model model )
    {

        Review review= new Review();

        // review.setReview_date();
        Iterable<Review> reviews= jdbcreview.findBymovie(id);
        model.addAttribute("newreview", review);
        model.addAttribute("data", jdbcRepos.findByid(id));
        model.addAttribute("review", reviews);

        ArrayList<String> Review_user_name= new ArrayList<>();

        ArrayList<String> Review_user= new ArrayList<>();
        String no_img= "https://cdn4.vectorstock.com/i/1000x1000/99/33/grey-user-sign-icon-vector-5059933.jpg";
        for (Review user_review:reviews
        ) {
            User u= userjdbc.findByID(user_review.getUser_id());
            String user_img =u.getUser_image();
            Review_user_name.add( u.getUsername());
            if(null!=user_img){
                Review_user.add(user_img);
            }else{
                Review_user.add(no_img);
            }

        }
        model.addAttribute("review_user", Review_user);
        model.addAttribute("user_name", Review_user_name);

        model.addAttribute("cast",castjdbc.findCast(id));
        if(null!=UserController.user)
            model.addAttribute("user", UserController.user);

        return"user_views/ViewMovie";
    }

}
