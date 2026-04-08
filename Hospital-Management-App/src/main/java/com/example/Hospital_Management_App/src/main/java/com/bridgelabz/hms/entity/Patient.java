package com.bridgelabz.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ change this
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber; // ✅ better as String (handles leading 0, +91)
}