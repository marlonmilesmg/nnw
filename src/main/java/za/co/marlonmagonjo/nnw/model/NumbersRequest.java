package za.co.marlonmagonjo.nnw.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumbersRequest {
    private int[] numbers;
}
