package com.atguigu.mybatisplusdemo;

import com.atguigu.mybatisplusdemo.mapper.DiseaseMapper;
import com.atguigu.mybatisplusdemo.mapper.DoctorMapper;
import com.atguigu.mybatisplusdemo.mapper.HospitalMapper;
import com.atguigu.mybatisplusdemo.mapper.PrecautionMapper;
import com.atguigu.mybatisplusdemo.mapper.SymptomsMapper;
import com.atguigu.mybatisplusdemo.mapper.UserMapper;
import com.atguigu.mybatisplusdemo.mapper.UserPrecautionMapper;
import com.atguigu.mybatisplusdemo.pojo.Disease;
import com.atguigu.mybatisplusdemo.pojo.Doctor;
import com.atguigu.mybatisplusdemo.pojo.Hospital;
import com.atguigu.mybatisplusdemo.pojo.Precaution;
import com.atguigu.mybatisplusdemo.pojo.Symptoms;
import com.atguigu.mybatisplusdemo.pojo.User;
import com.atguigu.mybatisplusdemo.pojo.UserPrecaution;
import com.atguigu.mybatisplusdemo.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {


  @Autowired
  DiseaseMapper diseaseMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  UserService userService;

  @Autowired
  HospitalMapper hospitalMapper;

  @Autowired
  PrecautionMapper precautionMapper;

  @Autowired
  UserPrecautionMapper userPrecautionMapper;

  @Autowired
  DoctorMapper doctorMapper;

  @Autowired
  SymptomsMapper symptomsMapper;


  @Test
  void testGetAllDisease() {
    List<Disease> diseases = diseaseMapper.selectList(null);
    System.out.println(diseases);
  }

//  test add user
//  name, email, age, gender, hospital_id, disease_i;
  @Test
  void testAddUser() {
    User user = new User();
//    user.setId(1);
    user.setEmail("t@g.com");
    user.setAge(20);
    user.setGender("male");
    int res = userMapper.insert(user);
    System.out.println(res);
  }



  // test delete user by calling Mysql procedure
  @Test
  void testDeleteById(){
    int res = userMapper.deleteById(391745541);
    System.out.println(res);
  }

  @Test
  void testInsertAll() {
    User user = new User();

    user.setAge(20);

    int i = userMapper.callCreateUserProcedure(user.getFirstName(), user.getEmail(), user.getAge(), user.getGender());
    System.out.println(i);
  }

  @Test
  void testUpdateUser(){
    User user = userMapper.selectById(391745542);
    user.setEmail("a@g.com");
    int res = userMapper.updateById(user);
    System.out.println(res);
  }


  @Test
  void testAddHospital() {
    Hospital hospital = new Hospital();
    hospital.setId(1);
    hospital.setName("BosGeneral");
    int res = hospitalMapper.insert(hospital);
    System.out.println(res);
  }



  @Test
  void testGetPrecautionsId(){
    Precaution precautions = precautionMapper.selectById(1);
    System.out.println(precautions);
  }

  @Test
  void testAddUserPrecaution(){
    UserPrecaution userPrecaution = new UserPrecaution();
    userPrecaution.setUserId(1);
    userPrecaution.setPrecautionId(1);
    int res = userPrecautionMapper.insert(userPrecaution);
    System.out.println(res);
  }

  @Test
  void addDoctor(){
    Doctor doctor = new Doctor();
    doctor.setFirstName("Jeff");
    doctor.setLastName("Sancho");
    doctor.setSpecializationName("Cardiologist");
    doctor.setQualification("MBBS");
    doctor.setHospitalId(1);
    int res = doctorMapper.insert(doctor);
    System.out.println(res);
  }

  @Test
  void testGetSymptomsByUserId(){
    List<Symptoms> symptoms = symptomsMapper.getSymptomsByUserId(8);
    System.out.println(symptoms);
  }

  @Test
  void testGetPrecautionsByUserId(){
    List<Precaution> precautions = precautionMapper.getPrecautionsByUserId(8);
    System.out.println(precautions);
  }
}
