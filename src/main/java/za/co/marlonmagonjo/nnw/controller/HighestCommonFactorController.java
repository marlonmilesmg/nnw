package za.co.marlonmagonjo.nnw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.marlonmagonjo.nnw.service.HighestCommonFactorService;
import za.co.marlonmagonjo.nnw.model.NumbersRequest;

@Slf4j
@RestController
@RequestMapping("/api")
public class HighestCommonFactorController {
    private final HighestCommonFactorService hcfService;

    public HighestCommonFactorController(HighestCommonFactorService hcfService) {
        this.hcfService = hcfService;
    }

    /**
     * Calculates the highest common factor (HCF) of an array of integers provided in the request body.
     *
     * @param numbers The request body containing an array of integers.
     * @return ResponseEntity containing the calculated HCF if successful, otherwise returns an appropriate error message.
     */
    @PostMapping("/hcf")
    public ResponseEntity<?> highestCommonFactor(@RequestBody NumbersRequest numbers) {
        if (numbers == null || numbers.getNumbers() == null || numbers.getNumbers().length == 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Numbers array cannot be null or empty");
        }

        try {
            int hcf = hcfService.calculateHCF(numbers);
            return ResponseEntity.ok(hcf);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (NullPointerException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Numbers cannot be null");
        }
    }

}
