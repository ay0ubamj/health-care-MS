package com.msproject.PatientService.Controller;

import com.msproject.PatientService.Entity.Appointment;
import com.msproject.PatientService.Entity.ClinicalNote;
import com.msproject.PatientService.Entity.Patient;
import com.msproject.PatientService.Service.AppointmentProxy;
import com.msproject.PatientService.Service.ClinicalNotesProxy;
import com.msproject.PatientService.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppointmentProxy appointmentProxy;
    @Autowired
    private ClinicalNotesProxy clinicalNotesProxy;

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable("patientId") long patientId) {
        Patient patient = patientService.getPatientById(patientId);


//        ResponseEntity<List<ClinicalNote>> clinicalServiceResponse = restTemplate.exchange(
//                "http://Clinical-Service/clinical/patient/" + patientId,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<ClinicalNote>>() {
//                }
//        );
//        ResponseEntity<List<Appointment>> appointmentServiceResponse = restTemplate.exchange(
//
//                "http://Appointment-Service/appointment/patient/" + patientId,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Appointment>>() {
//                }
//        );
//        patient.setClinicalNoteList(clinicalServiceResponse.getBody());
//        patient.setAppointmentList(appointmentServiceResponse.getBody());

        patient.setClinicalNoteList(clinicalNotesProxy.getClinicalNotes(patientId));
        patient.setAppointmentList(appointmentProxy.getAppointments(patientId));

        return patientService.getPatientById(patientId);
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        patientService.savePatient(patient);
        return patient;
    }
}
