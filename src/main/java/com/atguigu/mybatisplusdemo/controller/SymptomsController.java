package com.atguigu.mybatisplusdemo.controller;

import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomsController {

    @Autowired
    SymptomsService symptomsService;

    @GetMapping("/symptoms/{diseaseId}")
    public List<Symptoms> getSymptomsByDiseaseId(@PathVariable("diseaseId") Integer diseaseId) {
        System.out.println("diseaseId = " + diseaseId);
        return symptomsService.getSymptomsByDiseaseId(diseaseId);
    }

    @GetMapping("/symptoms/user/{userId}")
    public List<Symptoms> getSymptomsByUserId(@PathVariable("userId") Integer userId) {
        System.out.println("userId = " + userId);
        return symptomsService.getSymptomsByUserId(userId);
    }

    @GetMapping("/symptoms")
    public List<Symptoms> getAllSymptoms() {
        List<Symptoms> symptoms = symptomsService.list();
        return symptoms;
    }

    @GetMapping("/symptom/name/{diseaseName}")
    public List<Symptoms> getSymptomsByDiseaseName(@PathVariable("diseaseName") String diseaseName) {
        System.out.println("diseaseName = " + diseaseName);
        return symptomsService.getSymptomsByDiseaseName(diseaseName);
    }
}
