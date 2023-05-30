package com.testtask.backendCodingTask.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ratings {
    @Id
    @Column(name = "tconst",nullable = false)
    private String id;

    @Column(nullable = false)
    private Float averageRating;
    @Column(nullable = false)
    private Integer numVotes;

//    @OneToOne
//    @JoinColumn(name = "tconst_id")
//    private Movies movies;
}
