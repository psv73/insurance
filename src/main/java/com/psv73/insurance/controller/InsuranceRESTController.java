package com.psv73.insurance.controller;

import com.psv73.insurance.model.*;
import com.psv73.insurance.repository.InsuranceRepository;
import com.psv73.insurance.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class InsuranceRESTController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private Rate rate;

    @GetMapping()
    public List<Insurance> main(Map<String, Object> model) {

        return insuranceRepository.findAll();
    }

    @GetMapping("{id}")
    public Map<String, Object> getOne(@PathVariable("id") Insurance insurance) {

        return Utils.editData(Optional.ofNullable(insurance));
    }

    @PostMapping
    public Insurance createInsurance(@RequestBody Insurance insurance) {

        insurance.setDateStamp(LocalDateTime.now());
        insuranceRepository.save(insurance);

        return insurance;
    }

    @PutMapping("{id}")
    public Insurance updateInsurance(@PathVariable("id") Insurance insuranceFromDB, @RequestBody Insurance insurance) {

        insurance.setDateStamp(LocalDateTime.now());
        BeanUtils.copyProperties(insurance, insuranceFromDB, "id");

        return insuranceRepository.save(insuranceFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteInsurance(@PathVariable("id") Insurance insurance) {

        insuranceRepository.delete(insurance) ;
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

}
