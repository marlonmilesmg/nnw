package za.co.marlonmagonjo.nnw.service;

import org.springframework.stereotype.Service;
import za.co.marlonmagonjo.nnw.model.NumbersRequest;

@Service
public class HighestCommonFactorService {
    public int calculateHCF(NumbersRequest numbers) {
        if (numbers == null) {
            throw new NullPointerException("Numbers cannot be null");
        }

        int[] numbersArray = numbers.getNumbers();

        if (numbersArray.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        for (int num : numbersArray) {
            if (num < 0) {
                throw new IllegalArgumentException("Array must contain only positive numbers");
            }

            if (num == 0) {
                return 0;
            }
        }

        int hcf = numbersArray[0];
        for (int i = 1; i < numbersArray.length; i++) {
            hcf = findHCF(hcf, numbersArray[i]);
        }
        return hcf;
    }

    private static int findHCF(int a, int b) {
        if (a == 0 || b == 0) {
            return Math.abs(a + b);
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // HCF is always positive
    }

}

