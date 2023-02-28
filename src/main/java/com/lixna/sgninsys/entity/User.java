package com.lixna.sgninsys.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lixna
 * @since 2023-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String phone;

    private String password;

    private String email;

    private Integer role;

    private Integer classId;

    private String realName;

    private String nickName;

    private String sex;

    private Integer age;

    @TableField(value = "created_at",fill = FieldFill.INSERT)
    private Date createdAt;

    @TableField(value = "updated_at",fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
