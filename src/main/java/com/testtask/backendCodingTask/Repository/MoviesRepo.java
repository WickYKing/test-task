package com.testtask.backendCodingTask.Repository;

import com.testtask.backendCodingTask.Entity.Movies;
import com.testtask.backendCodingTask.PayLoads.MoviesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MoviesRepo extends JpaRepository<Movies,String > {
    List<Movies> findTop10ByOrderByRuntimeMinutesDesc();

    //List<Movies> findByRatingsAverageRatingGreaterThan(Float averageRating);
    @Query(value = "SELECT m.genres,m.primaryTitle, SUM(r.numVotes) AS subtotal FROM Movies m " +
            "INNER JOIN Ratings r ON m.id = r.id " +
            "GROUP BY m.genres,m.primaryTitle")
    List<Object[]> getGenreMoviesWithSubtotals();

    @Modifying
    @Transactional
    @Query(value = "UPDATE Movies SET runtimeMinutes = " +
            " (CASE " +
            " WHEN genres = 'Documentary' THEN runtimeMinutes + 15 " +
            " WHEN genres = 'Animation' THEN runtimeMinutes + 30 " +
            " ELSE runtimeMinutes + 45 " +
            " END)")
 void updateRuntimeMinutes();
}

