package com.msproject.PatientService.Service;

import com.msproject.PatientService.Entity.Patient;
import com.msproject.PatientService.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient savePatient(Patient patient);
}
