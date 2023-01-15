package com.msproject.ClinicalService.Repository;

import com.msproject.ClinicalService.Entity.ClinicalNote;
import org.springframework.data.repository.CrudRepository;

public interface ClinicalRepository extends CrudRepository<ClinicalNote, Long> {
}
