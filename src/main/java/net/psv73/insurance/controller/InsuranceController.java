package net.psv73.insurance.controller;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.model.Rate;
import net.psv73.insurance.repository.InsuranceRepository;
import net.psv73.insurance.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private Rate rate;

    @GetMapping
    public String main(Model model) {

        model.addAttribute("insurances", insuranceRepository.findAll());

        return "main";
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable("id") Insurance insurance, Model model) {

        model.addAllAttributes(Utils.editData(Optional.ofNullable(insurance)));

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
