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
@ApiModel(value="Lesson对象", description="")
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "lesson_id", type = IdType.ID_WORKER_STR)
    private Integer lessonId;

    private String lessonName;

    private Integer lessonCreatorId;

    @TableField(value = "created_at",fill = FieldFill.INSERT)
    private Date createdAt;

    @TableField(value = "updated_at",fill = FieldFill.INSERT_UPDATE)
    private Date updatedAt;

    @TableField("deleted")
    @TableLogic
    private Integer deleted;


}
