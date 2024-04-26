package za.co.marlonmagonjo.nnw;

public class HighestCommonFactor {

    public static void main(String[] args) {
        int[] numbers = {12, 24, 36};
        try {
            System.out.println("Highest Common Factor: " + highestCommonFactor(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int highestCommonFactor(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }

        int hcf = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            hcf = calculateHCF(hcf, numbers[i]);
        }
        return hcf;
    }
    
    private static int calculateHCF(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
