package com.infosharing.project;

import com.atguigu.mybatisplusdemo.mapper.*;
import com.atguigu.mybatisplusdemo.pojo.*;
import com.infosharing.project.mapper.CommentsMapper;
import com.infosharing.project.mapper.DiseaseMapper;
import com.infosharing.project.mapper.DoctorMapper;
import com.infosharing.project.mapper.HospitalMapper;
import com.infosharing.project.mapper.PrecautionMapper;
import com.infosharing.project.mapper.SymptomsMapper;
import com.infosharing.project.mapper.UserPrecautionMapper;
import com.infosharing.project.pojo.Comments;
import com.infosharing.project.pojo.Disease;
import com.infosharing.project.pojo.Doctor;
import com.infosharing.project.pojo.Hospital;
import com.infosharing.project.pojo.Precaution;
import com.infosharing.project.pojo.Symptoms;
import com.infosharing.project.pojo.User;
import com.infosharing.project.pojo.UserDTO;
import com.infosharing.project.pojo.UserPrecaution;
import com.infosharing.project.service.CommentsService;
import com.infosharing.project.service.UserService;
import com.infosharing.project.mapper.UserMapper;

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

  @Autowired
  CommentsMapper commentsMapper;

  @Autowired
  CommentsService commentsService;

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

//  @Test
//  void testInsertAll() {
//    User user = new User();
//
//    user.setAge(20);
//
//    int i = userMapper.callCreateUserProcedure(user.getFirstName(), user.getEmail(), user.getAge(), user.getGender());
//    System.out.println(i);
//  }

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
    userPrecaution.setUserId(2);
    userPrecaution.setPrecautionId(5);
    int res = userPrecautionMapper.insert(userPrecaution);
    System.out.println(res);
  }

  @Test
  void addDoctor(){
    Doctor doctor = new Doctor();
    doctor.setFirstName("Jeffery");
    doctor.setLastName("Sancho");
    doctor.setSpecializationName("Cardiologist");
    doctor.setQualification("MBBS");
    doctor.setHospitalId(1);
    int res = doctorMapper.insertOneDoctor(doctor);
    System.out.println(res);
  }

  @Test
  void testGetSymptomsByUserId(){
    List<Symptoms> symptoms = symptomsMapper.getSymptomsByUserId(8);
    System.out.println(symptoms);
  }

  @Test
  void testGetPrecautionsByUserId(){
    List<Integer> precautions = precautionMapper.getPrecautionsIDsByUserId(8);
    System.out.println(precautions);
  }

  @Test
  void testGetAllDoctors(){
    List<Doctor> doctors = doctorMapper.getAllDoctors();
    System.out.println(doctors);
  }

  @Test
  void testCreateUser(){
    UserDTO user = new UserDTO();
    user.setFirstName("Zhangsan");
    user.setLastName("Z");
    user.setEmail("qz@g.com");
    user.setAge(20);
    int insert = userService.insert(user);
    System.out.println(insert);

  }

  @Test
  void testGetCommentsByBlog() {
    List<Comments> comments = commentsService.getCommentByBlogId(2);
    System.out.println("Here is the comment!");
    System.out.println(comments);
  }


}
