package net.psv73.insurance.controller;

import net.psv73.insurance.dao.InsuranceDAO;
import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping
    public String list(Map<String, Object> model) {

        Iterable<Insurance> insurances = insuranceRepository.findAll();

        return "main";
    }

    @GetMapping("{id}")
    public Insurance getOne(@PathVariable String id) {
        return InsuranceDAO.getInsuranceByID(id);
    }
}
