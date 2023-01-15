package com.msproject.AppointmentService.Service.Implementation;

import com.msproject.AppointmentService.Entity.Appointment;
import com.msproject.AppointmentService.Repository.AppointmentRepository;
import com.msproject.AppointmentService.Service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImp(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).get();
    }

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
