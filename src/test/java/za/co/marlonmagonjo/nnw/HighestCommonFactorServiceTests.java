package za.co.marlonmagonjo.nnw;

import org.junit.jupiter.api.Test;
import za.co.marlonmagonjo.nnw.model.NumbersRequest;
import za.co.marlonmagonjo.nnw.service.HighestCommonFactorService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestCommonFactorServiceTests {

    @Test
    public void test_valid_array() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        NumbersRequest numbersRequest = NumbersRequest.builder()
                .numbers(new int[]{12, 18, 24})
                .build();
        int result = hcfService.calculateHCF(numbersRequest);
        assertEquals(6, result);
    }

    @Test
    public void test_array_with_zero() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        NumbersRequest numbersRequest = NumbersRequest.builder()
                .numbers(new int[]{6, 0, 12})
                .build();
        int result = hcfService.calculateHCF(numbersRequest);
        assertEquals(0, result);
    }
}
