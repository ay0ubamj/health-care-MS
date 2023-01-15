package com.msproject.ClinicalService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ClinicalNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Europe/Zagreb")
    private LocalDateTime date;
    private String author;
    private String content;
    private Long patientId;
    @Transient
    private List<Laboratory> laboratoryTests;
}
