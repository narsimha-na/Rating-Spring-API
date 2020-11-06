package com.na.Rating.DAO;

import com.na.Rating.entity.Rating;
import org.springframework.data.mongodb.config.MongoDbFactoryParser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository  extends MongoRepository<Rating,Integer> {
}
