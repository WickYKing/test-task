package com.testtask.backendCodingTask.PayLoads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MoviesDto {

        private String id;
        @NotEmpty(message = "Please enter the movie title type.")
        private String titleType;
        @NotEmpty(message = "Please enter the movie name.")
        private String primaryTitle;
        @NotEmpty
        @NotNull(message = "Please enter the valid time.")
        private Integer runtimeMinutes;
        @NotEmpty(message = "Please enter genres type.")
        private String genres;

        public MoviesDto(String id, String primaryTitle, String genres, Object o) {
        }


//        private Ratings ratings;
    }
