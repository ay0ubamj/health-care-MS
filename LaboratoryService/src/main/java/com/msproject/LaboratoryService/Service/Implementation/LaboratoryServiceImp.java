package com.msproject.LaboratoryService.Service.Implementation;

import com.msproject.LaboratoryService.Entity.Laboratory;
import com.msproject.LaboratoryService.Repository.LaboratoryRepository;
import com.msproject.LaboratoryService.Service.LaboratoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryServiceImp implements LaboratoryService {
    private LaboratoryRepository laboratoryRepository;

    public LaboratoryServiceImp(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @Override
    public List<Laboratory> getAllLaboratoryTests() {
        return (List<Laboratory>) laboratoryRepository.findAll();
    }

    @Override
    public Laboratory getLaboratoryTestById(Long id) {
        return laboratoryRepository.findById(id).get();
    }

    @Override
    public Laboratory saveLaboratoryTest(Laboratory laboratoryTest) {
        return laboratoryRepository.save(laboratoryTest);
    }
}
