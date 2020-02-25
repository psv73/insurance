package net.psv73.insurance.controller;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping
    public ModelAndView main(Map<String, Object> model) {

        List<Insurance> insurances = insuranceRepository.findAll();

        model.put("insurances", insurances);

        return new ModelAndView("index", model);
    }

    @GetMapping("{id}")
    public String getOne(@PathVariable String id, Map<String, Object> model) {

        Optional<Insurance> insurance = insuranceRepository.findById(Integer.parseInt(id));

        model.put("insurances", insurance);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {

        return "main";
    }


}
