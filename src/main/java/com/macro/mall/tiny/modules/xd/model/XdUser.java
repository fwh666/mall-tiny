package com.macro.mall.tiny.modules.xd.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@Accessors(chain =true)
@TableName("xd_user")
@Schema(name = "XdUser", description = "用户基本信息表")
public class XdUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "UID")
    private String uid;

    @Schema(description = "用户名昵称")
    private String userName;

    @Schema(description = "用户密码")
    private String password;
    @Schema(description = "头像URL")
    private String avatarImage;

    @Schema(description = "性别0-未知 1-男 2-女")
    private Boolean sex;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "出生年份")
    private Integer year;

    @Schema(description = "出生月份")
    private Integer month;

    @Schema(description = "出生日份")
    private Integer day;

    @Schema(description = "星座")
    private String constellation;

    @Schema(description = "身高cm")
    private Integer height;

    @Schema(description = "体重kg")
    private Integer weight;

    @Schema(description = "学历")
    private String education;

    @Schema(description = "学校")
    private String school;

    @Schema(description = "工作职位")
    private String job;

    @Schema(description = "现居住地")
    private String address;

    @Schema(description = "家乡籍贯")
    private String hometown;

    @Schema(description = "年收入")
    private String income;

    @Schema(description = "婚姻状况")
    private String marriage;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;

    @Schema(description = "删除标识 0-未 1-删除")
    private Boolean deleted;
}
