package com.msproject.AppointmentService.Service;

import com.msproject.AppointmentService.Entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment saveAppointment(Appointment appointment);
}
