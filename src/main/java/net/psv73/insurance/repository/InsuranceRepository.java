package net.psv73.insurance.repository;

import net.psv73.insurance.model.Insurance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

    List<Insurance> findAll();

}
