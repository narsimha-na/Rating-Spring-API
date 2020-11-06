package com.na.Rating.controller;

import com.na.Rating.entity.AverageRatingResponse;
import com.na.Rating.entity.Rating;
import com.na.Rating.entity.UserResponse;
import com.na.Rating.service.RatingServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServices ratingServices;

    // Gets all the ratings
    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingServices.getAllRatings();
    }
    // Create Rating based on email
    @PostMapping(path = "/create")
    public UserResponse createRating(@RequestBody Rating reqBody){
        return  ratingServices.createRating(reqBody);
    }

    // Gets Average Rating based on email
    @GetMapping(path = "/{user_id}")
    public AverageRatingResponse getAverageRatingResponse(@PathVariable("user_id") String user_id){
        return ratingServices.getAverageRatingResponse(user_id);
    }

    //Gets all rating based on on email
    @GetMapping(path = "/getRatingBasedOnEmail/{user_id}")
    public List<Rating> getRatingsBasedOnEmail(@PathVariable("user_id") String user_id){
        return ratingServices.getRatingBasedEmail(user_id);
    }

    // Delete all the Ratings
    @DeleteMapping
    public UserResponse deleteRating(){
        return ratingServices.deleteAll();
    }


}
