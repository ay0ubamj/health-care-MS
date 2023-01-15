package com.msproject.PatientService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String cin;
    private int telephone;
    @Transient
    private List<ClinicalNote> clinicalNoteList;
    @Transient
    private List<Appointment> appointmentList;
}
