package com.testtask.backendCodingTask.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="movies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movies {
    @Id
    @Column(name ="tconst")
    private String id;

    @Column(nullable = false, length = 50)
    private String titleType;
    @Column(nullable = false, length = 100)
    private String primaryTitle;
    private Integer runtimeMinutes;
    private String genres;


//    @OneToOne(mappedBy = "movies",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Ratings ratings;
}
