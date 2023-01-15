package com.msproject.LaboratoryService.Service;

import com.msproject.LaboratoryService.Entity.Laboratory;

import java.util.List;

public interface LaboratoryService {
    List<Laboratory> getAllLaboratoryTests();
    Laboratory getLaboratoryTestById(Long id);
    Laboratory saveLaboratoryTest(Laboratory laboratoryTest);
}
