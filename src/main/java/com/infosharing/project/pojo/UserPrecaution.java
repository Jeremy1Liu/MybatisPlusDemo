package com.infosharing.project.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName user_precaution
 */
@TableName(value ="user_precaution")
@Data
public class UserPrecaution implements Serializable {
    private Integer userId;

    private Integer precautionId;

    private static final long serialVersionUID = 1L;
}