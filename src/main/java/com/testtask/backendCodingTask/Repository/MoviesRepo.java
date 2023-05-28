package com.testtask.backendCodingTask.Repository;

import com.testtask.backendCodingTask.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoviesRepo extends JpaRepository<Movies,String > {
    List<Movies> findTop10ByOrderByRuntimeMinutesDesc();

}
