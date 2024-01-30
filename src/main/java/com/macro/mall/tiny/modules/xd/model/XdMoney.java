package com.macro.mall.tiny.modules.xd.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户金额表
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("xd_money")
@Schema(name = "XdMoney", description = "用户金额表")
public class XdMoney implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户ID")
    private String uid;

    @Schema(description = "剩余金额")
    private Integer residueMoney;

    @Schema(description = "付费充值金额")
    private Integer payMoney;

    @Schema(description = "免费获取的金额")
    private Integer freeMoney;

    @Schema(description = "收益金额")
    private Integer incomeMoney;
}
