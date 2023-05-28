package com.testtask.backendCodingTask.Repository;

import com.testtask.backendCodingTask.Entity.Movies;
import com.testtask.backendCodingTask.Entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Ratings,String> {

    List<Ratings> findByAverageRatingGreaterThanOrderByAverageRatingDesc(float averageRating);

}
