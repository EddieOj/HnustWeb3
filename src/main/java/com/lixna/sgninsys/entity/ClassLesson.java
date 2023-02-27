package com.lixna.sgninsys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="ClassLesson对象", description="")
public class ClassLesson implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_lesson_id", type = IdType.AUTO)
    private Integer classLessonId;

    private Integer classId;

    private Integer lessonId;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;


}
