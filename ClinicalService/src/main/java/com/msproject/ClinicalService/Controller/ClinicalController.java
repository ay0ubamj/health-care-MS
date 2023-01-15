package com.msproject.ClinicalService.Controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msproject.ClinicalService.Entity.ClinicalNote;
import com.msproject.ClinicalService.Entity.Laboratory;
import com.msproject.ClinicalService.Service.ClinicalService;
import com.msproject.ClinicalService.Service.LaboratoryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clinical")
public class ClinicalController {
    @Autowired
    private ClinicalService clinicalService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LaboratoryProxy laboratoryProxy;

    @GetMapping("/patient/{patientId}")
    public List<ClinicalNote> getPatientClinicalNotes(@PathVariable long patientId) throws IOException {
//        List<ClinicalNote> patientClinicalNotes = clinicalService.getAllClinicalNotes()
//                .stream()
//                .filter(clinicalNote -> clinicalNote.getPatientId() == patientId)
//                .map(clinicalNote -> {
//                    ResponseEntity<List<Laboratory>> laboratoryServiceResponse = restTemplate.exchange(
//                            "http://Laboratory-Service/laboratory/"+clinicalNote.getId(),
//                            HttpMethod.GET,
//                            null,
//                            new ParameterizedTypeReference<List<Laboratory>>() {}
//                    );
//                    clinicalNote.setLaboratoryTests(laboratoryServiceResponse.getBody());
//                    return clinicalNote;
//                })
//                .collect(Collectors.toList());
//
//        return patientClinicalNotes;
        return laboratoryProxy.getPatientClinicalNotes(patientId);
    }

    @PostMapping("/add")
    public ClinicalNote addClinicalNote(@RequestBody ClinicalNote clinicalNote) {
        return clinicalService.saveClinicalNote(clinicalNote);
    }
}
