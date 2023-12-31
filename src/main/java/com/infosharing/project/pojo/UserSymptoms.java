package com.infosharing.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user_symptoms
 */
@TableName(value ="user_symptoms")
@Data
public class UserSymptoms implements Serializable {
    private Integer userId;

    private Integer symptomsId;

    private static final long serialVersionUID = 1L;
}