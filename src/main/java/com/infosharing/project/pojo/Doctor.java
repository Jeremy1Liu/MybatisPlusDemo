package com.infosharing.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName doctor
 */
@TableName(value ="doctor")
@Data
public class Doctor implements Serializable {
    private Integer id;

    private String firstName;

    private String lastName;

    private Object specializationName;

    private Object qualification;

    private Integer hospitalId;

    private static final long serialVersionUID = 1L;
}