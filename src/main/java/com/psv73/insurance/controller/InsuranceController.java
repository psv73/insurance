package com.psv73.insurance.controller;

import com.psv73.insurance.model.Rate;
import com.psv73.insurance.util.Utils;
import com.psv73.insurance.model.Insurance;
import com.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

//@Controller
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private Rate rate;

    @GetMapping
    public String main(Model model) {

        model.addAttribute("insurances", insuranceRepository.findAll());

        return "index";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable("id") Insurance insurance, Model model) {

        model.addAllAttributes(Utils.getInsurance(Optional.ofNullable(insurance)));

        return "main";
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

}
