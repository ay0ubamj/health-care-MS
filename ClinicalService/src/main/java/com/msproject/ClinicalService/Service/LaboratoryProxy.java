package com.msproject.ClinicalService.Service;

import com.msproject.ClinicalService.Entity.ClinicalNote;
import com.msproject.ClinicalService.Entity.Laboratory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaboratoryProxy {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ClinicalService clinicalService;

    @HystrixCommand(fallbackMethod = "getFallBackClinicalNotes")
    public List<ClinicalNote> getPatientClinicalNotes(long patientId){
        List<ClinicalNote> patientClinicalNotes = clinicalService.getAllClinicalNotes()
                .stream()
                .filter(clinicalNote -> clinicalNote.getPatientId() == patientId)
                .map(clinicalNote -> {
                    ResponseEntity<List<Laboratory>> laboratoryServiceResponse = restTemplate.exchange(
                            "http://Laboratory-Service/laboratory/"+clinicalNote.getId(),
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Laboratory>>() {}
                    );
                    clinicalNote.setLaboratoryTests(laboratoryServiceResponse.getBody());
                    return clinicalNote;
                })
                .collect(Collectors.toList());

        return patientClinicalNotes;
    }

    public List<ClinicalNote> getFallBackClinicalNotes(long patientId){
        List<ClinicalNote> patientClinicalNotes = clinicalService.getAllClinicalNotes()
                .stream()
                .filter(clinicalNote -> clinicalNote.getPatientId() == patientId)
                .map(clinicalNote -> {
                    ArrayList<Laboratory> laboArray = new ArrayList<>();
                    laboArray.add(new Laboratory(0L, null, "no test type", "no test details", 0L));
                    clinicalNote.setLaboratoryTests(laboArray);
                    return clinicalNote;
                })
                .collect(Collectors.toList());
        return patientClinicalNotes;
    }
}
