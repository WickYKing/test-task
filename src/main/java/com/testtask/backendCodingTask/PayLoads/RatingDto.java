package com.testtask.backendCodingTask.PayLoads;

import com.testtask.backendCodingTask.Entity.Movies;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class RatingDto {
    @NotEmpty
    private String id;
    @NotEmpty
    @NotNull(message = "Please enter the valid rating")
    private Float averageRating;
    @NotEmpty
    private String numVotes;

//    private Movies movies;
}
