package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.mapper.HospitalMapper;
import com.atguigu.mybatisplusdemo.pojo.Doctor;
import com.atguigu.mybatisplusdemo.pojo.Hospital;
import com.atguigu.mybatisplusdemo.service.HospitalService;
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
