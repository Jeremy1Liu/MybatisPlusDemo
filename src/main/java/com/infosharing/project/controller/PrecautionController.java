package com.infosharing.project.controller;

import com.infosharing.project.pojo.Precaution;
import com.infosharing.project.service.PrecautionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrecautionController {

  @Autowired
  PrecautionService precautionService;

  @GetMapping("/precautions")
  public List<Precaution> getAllPrecaution() {
    List<Precaution> precautions = precautionService.list();
    return precautions;
  }

  @GetMapping("/precaution/user/{userId}")
  public List<Precaution> getPrecautionsByUserId(@PathVariable("userId") Integer userId) {
    return precautionService.getPrecautionsByUserId(userId);
  }

  @GetMapping("/precaution/{diseaseId}")
  public List<Precaution> getPrecautionByDiseaseId(@PathVariable("diseaseId") Integer diseaseId) {
    return precautionService.getPrecautionByDiseaseId(diseaseId);
  }

  @GetMapping("/precaution/name/{diseaseName}")
  public List<Precaution> getPrecautionByDiseaseName(
      @PathVariable("diseaseName") String diseaseName) {
    return precautionService.getPrecautionByDiseaseName(diseaseName);
  }
}
