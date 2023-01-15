package com.msproject.PatientService.Service;

import com.msproject.PatientService.Entity.Appointment;
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
public class AppointmentProxy {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackAppointments")
    public List<Appointment> getAppointments(long patientId){
        ResponseEntity<List<Appointment>> appointmentServiceResponse = restTemplate.exchange(
                "http://Appointment-Service/appointment/patient/" + patientId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Appointment>>() {
                }
        );
        return appointmentServiceResponse.getBody();
    }

    public List<Appointment> getFallBackAppointments(long patientId){
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(0L, 0L, null, "no details", "no reason"));
        return appointments;
    }
}
