package net.psv73.insurance.controller;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("insurance")
public class InsuranceController {

//    @Value("@(app.main.title)")
//    private String title = "";

    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping()
    public List<Insurance> main(Map<String, Object> model) {

        return insuranceRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Insurance> getOne(@PathVariable String id, Map<String, Object> model) {

        return insuranceRepository.findById(Long.parseLong(id));
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {

        return "main";
    }


}
