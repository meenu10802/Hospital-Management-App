package com.bridgelabz.hms.repository;

import com.bridgelabz.hms.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT p FROM Patient p WHERE p.disease = ?1")
    List<Patient> findByDisease(String disease);
    @Query("SELECT p FROM Patient p WHERE p.age > ?1")
    List<Patient> findPatientsAboveAge(int age);
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %?1%")
    List<Patient> searchByName(String name);

}
