package com.atguigu.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private String firstName;

    /**
     *
     */
    private String lastName;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String gender;

    /**
     *
     */
    private Integer hospitalId;

    /**
     *
     */
    private Integer diseaseId;

    /**
     *
     */
    private Integer doctorId;


    private List<Integer> precautions;

    private List<Integer> symptoms;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
