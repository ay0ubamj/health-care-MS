package com.msproject.ClinicalService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Laboratory {
    private Long id;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Europe/Zagreb")
    private LocalDateTime testDate;
    private String testType;
    private String testDetails;
    private Long clinicalId;
}
