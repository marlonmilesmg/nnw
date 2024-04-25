package za.co.marlonmagonjo.nnw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HighestCommonFactorV1Tests {

    @Test
    public void test_terminate_without_errors() {
        assertDoesNotThrow(() -> HighestCommonFactorV1.main(new String[]{}));
    }

    @Test
    public void test_input_array_null() {
        int[] numbers = null;

        assertThrows(IllegalArgumentException.class, () -> HighestCommonFactorV1.highestCommonFactor(numbers));
    }

    @Test
    public void test_input_array_empty() {
        int[] numbers = {};

        assertThrows(IllegalArgumentException.class, () -> HighestCommonFactorV1.highestCommonFactor(numbers));
    }

    @Test
    public void test_input_array_single_element() {
        int[] numbers = {5};

        int result = HighestCommonFactorV1.highestCommonFactor(numbers);

        assertEquals(5, result);
    }
}
