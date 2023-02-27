package com.lixna.sgninsys.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Class新建对象", description="")
public class ClassDto {
    private Integer creator;

    private String class_name;

    private Integer class_capacity;
}
