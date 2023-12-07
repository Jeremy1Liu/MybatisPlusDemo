package com.infosharing.project.controller;

import com.infosharing.project.pojo.Hospital;
import com.infosharing.project.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hospitals")
    public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.list();
        return hospitals;
    }
}
