package com.msproject.ClinicalService.Service.Implementation;

import com.msproject.ClinicalService.Entity.ClinicalNote;
import com.msproject.ClinicalService.Repository.ClinicalRepository;
import com.msproject.ClinicalService.Service.ClinicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalServiceImp implements ClinicalService {
    private ClinicalRepository clinicalRepository;

    public ClinicalServiceImp(ClinicalRepository clinicalRepository) {
        this.clinicalRepository = clinicalRepository;
    }

    @Override
    public List<ClinicalNote> getAllClinicalNotes() {
        return (List<ClinicalNote>) clinicalRepository.findAll();
    }

    @Override
    public ClinicalNote getClinicalNoteById(Long id) {
        return clinicalRepository.findById(id).get();
    }

    @Override
    public ClinicalNote saveClinicalNote(ClinicalNote clinicalNote) {
        return clinicalRepository.save(clinicalNote);
    }
}
