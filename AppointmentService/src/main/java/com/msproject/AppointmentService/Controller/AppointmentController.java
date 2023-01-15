package com.msproject.AppointmentService.Controller;

import com.msproject.AppointmentService.Entity.Appointment;
import com.msproject.AppointmentService.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getPatientAppointments(@PathVariable long patientId) {
        List<Appointment> patientAppointments = appointmentService.getAllAppointments()
                .stream()
                .filter(appointment -> appointment.getPatientId() == patientId)
                .collect(Collectors.toList());
        return patientAppointments;
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointment(@PathVariable long appointmentId) {
        return appointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping("/add")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }
}
