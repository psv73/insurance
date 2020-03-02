package net.psv73.insurance.controller;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.model.Person;
import net.psv73.insurance.model.Plan;
import net.psv73.insurance.model.Type;
import net.psv73.insurance.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
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
        Map<String, Object> data = new HashMap<>();
        data.put("innsurance", new Insurance());
        data.put("type", Type.values());
    return data;

    }


}
