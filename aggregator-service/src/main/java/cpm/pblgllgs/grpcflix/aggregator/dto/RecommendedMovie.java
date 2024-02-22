package cpm.pblgllgs.grpcflix.aggregator.dto;
/*
 *
 * @author pblgl
 * Created on 21-02-2024
 *
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendedMovie {

    private String title;
    private int year;
    private double rating;

}
