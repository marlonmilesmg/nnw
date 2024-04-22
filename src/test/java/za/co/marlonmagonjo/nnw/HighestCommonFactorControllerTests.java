package za.co.marlonmagonjo.nnw;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import za.co.marlonmagonjo.nnw.controller.HighestCommonFactorController;
import za.co.marlonmagonjo.nnw.model.NumbersRequest;
import za.co.marlonmagonjo.nnw.service.HighestCommonFactorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HighestCommonFactorControllerTests {

    @Test
    public void test_returns_correct_hcf_for_valid_input() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(new int[]{2, 4, 6});

        ResponseEntity<Integer> result = hcfController.highestCommonFactor(numbersRequest);

        assertEquals(2, result.getBody().intValue());
    }

    @Test
    public void test_throws_exception_when_input_array_is_null() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(null);

        assertThrows(NullPointerException.class, () -> {
            hcfController.highestCommonFactor(numbersRequest);
        });
    }
}
