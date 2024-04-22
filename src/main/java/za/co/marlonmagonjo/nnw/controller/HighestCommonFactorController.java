package za.co.marlonmagonjo.nnw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
     * Calculates the highest common factor (HCF) of the given numbers.
     *
     * @param numbers the numbers for which to calculate the HCF
     * @return the HCF as a ResponseEntity
     */
    @PostMapping("/hcf")
    public ResponseEntity<Integer> highestCommonFactor(@RequestBody NumbersRequest numbers) {
        log.debug("Calculating highest common factor for numbers: {}", numbers.getNumbers());
        int hcf = hcfService.calculateHCF(numbers);
        log.debug("Calculated HCF: {}", hcf);
        return ResponseEntity.ok(hcf);
    }
}
