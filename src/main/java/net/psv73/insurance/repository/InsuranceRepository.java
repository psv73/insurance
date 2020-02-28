package net.psv73.insurance.repository;

import net.psv73.insurance.model.Insurance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {

    List<Insurance> findAll();

    Optional<Insurance> findById(long parseLong);
}
