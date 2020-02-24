package net.psv73.insurance.repository;

import net.psv73.insurance.model.Insurance;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Integer> {
}
