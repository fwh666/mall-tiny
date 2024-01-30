package com.macro.mall.tiny.modules.xd.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户详情介绍表
 *
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Getter
@Setter
@Accessors(chain =true)
@Schema(name = "XdUserInfo", description = "用户详情介绍表 ")
public class XdUserInfoParams implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "用户ID")
    private String uid;

    @Schema(description = "语音介绍")
    private String audioInfo;

    @Schema(description = "图片集信息")
    private String pictureInfo;

    @Schema(description = "自我介绍")
    private String meInfo;

    @Schema(description = "家庭背景介绍")
    private String homeInfo;

    @Schema(description = "兴趣爱好介绍")
    private String interestInfo;

    @Schema(description = "爱情观")
    private String loveInfo;

    @Schema(description = "理想另一半")
    private String soulInfo;

    @Schema(description = "为什么单身")
    private String singleInfo;

    @Schema(description = "期待的生活")
    private String lifeInfo;

    @Schema(description = "自我标签")
    private String tagInfo;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Schema(description = "删除标识 0-未 1-删除")
    private Boolean deleted;
}
