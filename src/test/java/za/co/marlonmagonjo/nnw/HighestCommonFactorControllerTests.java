package za.co.marlonmagonjo.nnw;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.co.marlonmagonjo.nnw.controller.HighestCommonFactorController;
import za.co.marlonmagonjo.nnw.model.NumbersRequest;
import za.co.marlonmagonjo.nnw.service.HighestCommonFactorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HighestCommonFactorControllerTests {

    @Test
    public void test_throws_exception_when_input_array_is_null() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(null);

        assertThrows(NullPointerException.class, () -> {
            hcfController.highestCommonFactor(numbersRequest);
        });
    }

    @Test
    public void test_valid_array_of_positive_integers() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(new int[]{2, 4, 6, 8});

        ResponseEntity<?> response = hcfController.highestCommonFactor(numbersRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody());
    }

    @Test
    public void test_array_contains_zero() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(new int[]{2, 4, 0, 8});

        ResponseEntity<?> response = hcfController.highestCommonFactor(numbersRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody());
    }

    @Test
    public void test_input_array_contains_negative_numbers() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(new int[]{2, -4, 6, 8});

        ResponseEntity<?> response = hcfController.highestCommonFactor(numbersRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Array must contain only positive numbers", response.getBody());
    }

    @Test
    public void test_input_array_is_empty() {
        HighestCommonFactorService hcfService = new HighestCommonFactorService();
        HighestCommonFactorController hcfController = new HighestCommonFactorController(hcfService);
        NumbersRequest numbersRequest = new NumbersRequest(new int[]{});

        ResponseEntity<?> response = hcfController.highestCommonFactor(numbersRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Numbers array cannot be null or empty", response.getBody());
    }
}
