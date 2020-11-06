package com.na.Rating.service;

import com.na.Rating.DAO.RatingDAO;
import com.na.Rating.entity.AverageRatingResponse;
import com.na.Rating.entity.Rating;
import com.na.Rating.entity.UserResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RatingServices {

    @Autowired
    private RatingDAO ratingDAO;


    public List<Rating> getAllRatings() {
        return ratingDAO.getAllRatings();
    }

    public UserResponse createRating(Rating reqBody) {
        reqBody.setId(UUID.randomUUID());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        reqBody.setTime(dateFormat.format(date));
        return ratingDAO.createRating(reqBody);
    }

    public AverageRatingResponse getAverageRatingResponse(String user_id) {
        return ratingDAO.getAverageRating(user_id);
    }

    public List<Rating> getRatingBasedEmail(String user_id) {
        return ratingDAO.getRatingBasedOnEmail(user_id);
    }

    public UserResponse deleteAll() {
        return ratingDAO.deleteAll();
    }
}
