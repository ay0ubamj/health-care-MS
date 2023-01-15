package com.msproject.LaboratoryService.Controller;

import com.msproject.LaboratoryService.Entity.Laboratory;
import com.msproject.LaboratoryService.Service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;

    @GetMapping("/{clinidalId}")
    public List<Laboratory> getLaboratoryTests(@PathVariable("clinidalId") String clinicalId) {
        List<Laboratory> laboratoryTest = laboratoryService.getAllLaboratoryTests()
                .stream()
                .filter(laboratory -> laboratory.getClinicalId() == Long.parseLong(clinicalId))
                .collect(Collectors.toList());
        return laboratoryTest;
    }

    @PostMapping("/add")
    public Laboratory addLaboratoryTest(@RequestBody Laboratory laboratoryTest){
        return laboratoryService.saveLaboratoryTest(laboratoryTest);
    }
}
