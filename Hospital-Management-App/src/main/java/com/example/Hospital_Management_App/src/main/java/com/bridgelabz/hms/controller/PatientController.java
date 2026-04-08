package com.bridgelabz.hms.controller;

import com.bridgelabz.hms.dto.PatientDto;
import com.bridgelabz.hms.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // ✅ Add Patient
    @PostMapping
    public PatientDto addPatient(@RequestBody PatientDto dto) {
        return patientService.addPatient(dto);
    }

    // ✅ Get All Patients
    @GetMapping
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    // ✅ Get Patient by ID
    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    // ✅ Update Patient
    @PutMapping("/{id}")
    public PatientDto updatePatient(
            @PathVariable Long id,
            @RequestBody PatientDto dto
    ) {
        return patientService.updatePatient(id, dto);
    }

    // ✅ Delete Patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }
}