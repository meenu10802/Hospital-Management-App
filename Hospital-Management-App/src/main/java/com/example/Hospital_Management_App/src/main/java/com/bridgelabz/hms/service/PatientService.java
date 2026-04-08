package com.bridgelabz.hms.service;

import com.bridgelabz.hms.dto.PatientDto;
import com.bridgelabz.hms.entity.Patient;
import com.bridgelabz.hms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    // ✅ Add Patient
    public PatientDto addPatient(PatientDto dto) {

        Patient patient = mapToEntity(dto);
        return mapToDto(patientRepository.save(patient));
    }

    // ✅ Get All
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // ✅ Get By ID
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return mapToDto(patient);
    }

    // ✅ Update
    public PatientDto updatePatient(Long id, PatientDto dto) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDisease(dto.getDisease());
        patient.setAddress(dto.getAddress());
        patient.setPhoneNumber(dto.getPhoneNumber());

        return mapToDto(patientRepository.save(patient));
    }

    // ✅ Delete
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    // 🔁 Mapping Methods

    private Patient mapToEntity(PatientDto dto) {
        Patient p = new Patient();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setAge(dto.getAge());
        p.setGender(dto.getGender());
        p.setDisease(dto.getDisease());
        p.setAddress(dto.getAddress());
        p.setPhoneNumber(dto.getPhoneNumber());
        return p;
    }

    private PatientDto mapToDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getDisease(),
                patient.getAddress(),
                patient.getPhoneNumber()
        );
    }
}