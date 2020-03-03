package net.psv73.insurance.controller;

import net.psv73.insurance.model.*;
import net.psv73.insurance.repository.InsuranceRepository;
import net.psv73.insurance.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private Rate rate;

    @GetMapping()
    public List<Insurance> main(Map<String, Object> model) {

        return insuranceRepository.findAll();
    }

    @GetMapping("{id}")
    public Map<String, Object> getOne(@PathVariable String id, Map<String, Object> model) {

        return Utils.editData(insuranceRepository.findById(Integer.parseInt(id)), rate);
    }

    @PostMapping
    public Insurance addInsurance(@RequestBody Insurance insurance) {

        insurance.setDateStamp(LocalDateTime.now());
        insuranceRepository.save(insurance);

        return insurance;
    }

    @PutMapping
    public Insurance updateInsurance(@RequestBody Insurance insurance) {

        insurance.setDateStamp(LocalDateTime.now());
        insuranceRepository.save(insurance);

        return insurance;
    }

    @DeleteMapping("{id}")
    public void deleteInsurance(@PathVariable String id) {

        insuranceRepository.deleteById(Integer.parseInt(id));

        return;
    }

    /**
     * Automatic fill database for testing
     */
    @GetMapping("auto")
    public List<Insurance> auto() {

        Insurance insurance = new Insurance("Peter Biely", Type.SHORT, LocalDate.now(),
                LocalDate.now().plusMonths(2), Plan.EXTENDED, Person.THREE, 556);

        insurance.setDateStamp(LocalDateTime.now());
        insuranceRepository.save(insurance);

        List<Insurance> insurances = (List<Insurance>) insuranceRepository.findAll();

        return insurances;
    }

    @GetMapping("new")
    public Map<String, Object> newInsurance() {

        return Utils.editData(new Insurance(), rate);
    }
}
