package com.testtask.backendCodingTask.PayLoads;

import lombok.*;

import java.math.BigInteger;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenreMoviesSubtotalsDto {
    private String genre;
    private String primaryTitle;
    private Long subtotal;

}
