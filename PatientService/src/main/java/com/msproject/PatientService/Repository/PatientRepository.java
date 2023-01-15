package com.msproject.PatientService.Repository;

import com.msproject.PatientService.Entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
