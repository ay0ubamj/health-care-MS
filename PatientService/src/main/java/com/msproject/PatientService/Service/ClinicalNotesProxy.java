package com.msproject.PatientService.Service;

import com.msproject.PatientService.Entity.ClinicalNote;
import com.msproject.PatientService.Entity.Laboratory;
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

@Service
public class ClinicalNotesProxy {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackClinicalNotes")
    public List<ClinicalNote> getClinicalNotes(long patientId) {
        ResponseEntity<List<ClinicalNote>> clinicalServiceResponse = restTemplate.exchange(
                "http://Clinical-Service/clinical/patient/" + patientId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClinicalNote>>() {
                }
        );

        return clinicalServiceResponse.getBody();
    }

    public List<ClinicalNote> getFallBackClinicalNotes(long patientId){
        List<ClinicalNote> clinicalNotes = new ArrayList<>();
        ArrayList<Laboratory> laboArray = new ArrayList<>();
        laboArray.add(new Laboratory(0L, null, "no test type", "no test details", 0L));

        clinicalNotes.add(new ClinicalNote(0L, null, "no author", "no content", 0L, laboArray));
        return clinicalNotes;
    }
}
