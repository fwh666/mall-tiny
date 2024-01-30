package com.macro.mall.tiny.modules.xd.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Getter
@Setter
public class XdUserParams implements Serializable {

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "UID")
    private Long uid;

    @Schema(description = "用户名昵称")
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    @Schema(description = "头像URL")
    private String avatarImage;

    @Schema(description = "性别 1-男 2-女")
    @NotEmpty(message = "性别不能为空")
    private Boolean sex;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "出生年份")
    @NotEmpty(message = "出生年份不能为空")
    private Integer year;

    @Schema(description = "出生月份")
    @NotEmpty(message = "出生月份不能为空")
    private Integer month;

    @Schema(description = "出生日份")
    @NotEmpty(message = "出生日份不能为空")
    private Integer day;

    @Schema(description = "星座")
    private String constellation;

    @Schema(description = "身高cm")
    @NotEmpty(message = "身高不能为空")
    private Integer height;

    @Schema(description = "体重kg")
    @NotEmpty(message = "体重不能为空")
    private Integer weight;

    @Schema(description = "学历")
    private String education;

    @Schema(description = "学校")
    private String school;

    @Schema(description = "工作职位")
    private String job;

    @Schema(description = "现居住地")
    @NotEmpty(message = "现居住地不能为空")
    private String address;

    @Schema(description = "家乡籍贯")
    @NotEmpty(message = "家乡籍贯不能为空")
    private String hometown;

    @Schema(description = "年收入")
    private String income;

    @Schema(description = "婚姻状况")
    @NotEmpty(message = "婚姻状况不能为空")
    private String marriage;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Schema(description = "删除标识 0-未 1-删除")
    private Boolean deleted;
}
