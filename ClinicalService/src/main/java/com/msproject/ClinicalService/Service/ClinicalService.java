package com.msproject.ClinicalService.Service;

import com.msproject.ClinicalService.Entity.ClinicalNote;

import java.util.List;

public interface ClinicalService {
    List<ClinicalNote> getAllClinicalNotes();
    ClinicalNote getClinicalNoteById(Long id);
    ClinicalNote saveClinicalNote(ClinicalNote clinicalNote);
}
