package com.testtask.backendCodingTask.PayLoads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewMovieDto {

    private String id;
    private String titleType;
    @NotEmpty(message = "Please enter the movie name.")
    private String primaryTitle;
    @NotEmpty
    @NotNull(message = "Please enter the valid time.")
    private Integer runtimeMinutes;
    @NotEmpty(message = "Please enter genres type.")
    private String genres;
    @NotEmpty
    @NotNull(message = "Please enter the valid rating")
    private Float averageRating;
    @NotEmpty
    private Integer numVotes;
}
