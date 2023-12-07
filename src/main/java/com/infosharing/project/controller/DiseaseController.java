package com.infosharing.project.controller;

import com.infosharing.project.pojo.Disease;
import com.infosharing.project.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;

    @GetMapping("/diseases")
    public List<Disease> getAllDisease() {
        List<Disease> diseases = diseaseService.list();
        return diseases;
    }

    @GetMapping("/disease/{id}")
    public Disease getDiseaseById(@PathVariable("id") Integer id) {
        return diseaseService.getById(id);
    }
}
