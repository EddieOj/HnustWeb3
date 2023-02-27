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
@ApiModel(value="CheckinRec对象", description="")
public class CheckinRec implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "checkin_rec_id", type = IdType.AUTO)
    private Integer checkinRecId;

    private Integer checkinId;

    private Integer userId;

    private String userName;

    private Integer state;

    private Date endTime;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;


}
