package com.na.Rating.DAO;

import com.na.Rating.entity.AverageRatingResponse;
import com.na.Rating.entity.Rating;
import com.na.Rating.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingDAO {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public UserResponse createRating(Rating reqBody) {
        if(reqBody.getRating() <= 5){
            ratingRepository.insert(reqBody);
            return new UserResponse(false,"rating submitted successfully");
        }else{
            return new UserResponse(true,"rating should be between 1 to 5");
        }
    }

    public AverageRatingResponse getAverageRating(String user_id) {
        int rating = 0;
        int flag = 0;
        List<Rating> ratingList = ratingRepository.findAll();
        if (ratingList.size() != 0) {
            for (Rating value : ratingList) {
                if (value.getEmail().equals(user_id)) {
                    rating = rating + value.getRating();
                    flag++;
                }
            }
            rating=rating/flag;
        }
        return new AverageRatingResponse(user_id, rating);
    }

    public List<Rating> getRatingBasedOnEmail(String user_id) {
        List<Rating> ratingList = ratingRepository.findAll();
        List<Rating> sortedList = new ArrayList<>();
        if (ratingList.size() != 0){
            for (Rating item : ratingList){
                if(item.getEmail().equals(user_id)){
                    sortedList.add(item);
                }
            }
        }
        return sortedList;
    }

    public UserResponse deleteAll() {
        ratingRepository.deleteAll();
        return new UserResponse(false,"deleted successfully");
    }
}
