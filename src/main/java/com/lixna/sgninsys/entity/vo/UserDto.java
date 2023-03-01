package com.lixna.sgninsys.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: UserDto
 * @Auther: sln
 * @Date: 2021/04/22/18:15
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户登录对象", description = "")
public class UserDto implements Serializable {
    @ApiModelProperty(value = "电话")
    @NotEmpty(message = "电话不能为空！")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空！")
    private String password;
}
