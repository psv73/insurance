package net.psv73.insurance.controller;

import net.psv73.insurance.dao.InsuranceDAO;
import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping
    public String main(Map<String, Object> model) {

        Iterable<Insurance> insurances = insuranceRepository.findAll();

        model.put("insurances", insurances);

        return "main";
    }

    @GetMapping("{id}")
    public Insurance getOne(@PathVariable String id) {
        return InsuranceDAO.getInsuranceByID(id);
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {

        return "main";
    }


}
