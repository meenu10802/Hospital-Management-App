package com.bridgelabz.hms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber;
}