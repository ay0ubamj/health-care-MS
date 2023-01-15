package com.msproject.AppointmentService.Repository;

import com.msproject.AppointmentService.Entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
