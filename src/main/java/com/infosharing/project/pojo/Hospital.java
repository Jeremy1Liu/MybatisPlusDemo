package com.infosharing.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName hospital
 */
@TableName(value ="hospital")
@Data
public class Hospital implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}