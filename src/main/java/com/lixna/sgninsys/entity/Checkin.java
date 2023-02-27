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
@ApiModel(value="Checkin对象", description="")
public class Checkin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "考勤id")
    @TableId(value = "checkin_id", type = IdType.AUTO)
    private Integer checkinId;

    @ApiModelProperty(value = "发起者id")
    private Integer creatorId;

    @ApiModelProperty(value = "课程id")
    private Integer lessonId;

    private Date beginTime;

    private Date endTime;

    private String checkinCode;

    private String longitude;

    private String latitude;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;


}
