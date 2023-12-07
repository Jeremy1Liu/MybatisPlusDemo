package com.infosharing.project.controller;

import com.infosharing.project.pojo.Doctor;
import com.infosharing.project.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
  @Autowired
  DoctorService doctorService;

  // return all doctors
  @GetMapping("/doctors")
  public List<Doctor> getAllDoctors() {
    List<Doctor> doctors = doctorService.listAll();
    return doctors;
  }

  @GetMapping("/doctors/hospital/{hospitalId}")
  public List<Doctor> getDoctorsByHospitalId(@PathVariable("hospitalId") Integer hospitalId) {
    return doctorService.getDoctorsByHospitalId(hospitalId);
  }

  @GetMapping("/doctor/{id}")
  public Doctor getDoctorById(@PathVariable("id") Integer id) {
    return doctorService.getById(id);
  }

  @PostMapping("/doctor")
  public int createDoctor(@RequestBody Doctor doctor) {
    return doctorService.insertOneDoctor(doctor);
  }

  @DeleteMapping("/doctor/{id}")
  public boolean deleteDoctorById(@PathVariable("id") Integer id) {
    return doctorService.removeById(id);
  }

  @PutMapping("/doctor")
  public boolean updateDoctor(@RequestBody Doctor doctor) {
    return doctorService.updateById(doctor);
  }
}
