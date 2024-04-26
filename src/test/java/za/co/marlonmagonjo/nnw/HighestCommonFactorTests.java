package za.co.marlonmagonjo.nnw;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HighestCommonFactorTests {

    @Test
    public void test_terminate_without_errors() {
        assertDoesNotThrow(() -> HighestCommonFactor.main(new String[]{}));
    }

    @Test
    public void test_input_array_null() {
        int[] numbers = null;

        assertThrows(IllegalArgumentException.class, () -> HighestCommonFactor.highestCommonFactor(numbers));
    }

    @Test
    public void test_input_array_empty() {
        int[] numbers = {};

        assertThrows(IllegalArgumentException.class, () -> HighestCommonFactor.highestCommonFactor(numbers));
    }

    @Test
    public void test_input_array_single_element() {
        int[] numbers = {5};

        int result = HighestCommonFactor.highestCommonFactor(numbers);

        assertEquals(5, result);
    }
}
