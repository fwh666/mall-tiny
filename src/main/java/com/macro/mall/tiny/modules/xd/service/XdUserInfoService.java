package com.macro.mall.tiny.modules.xd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.xd.dto.XdUserInfoParams;
import com.macro.mall.tiny.modules.xd.model.XdUserInfo;

/**
 * <p>
 * 用户详情介绍表
 * 服务类
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
public interface XdUserInfoService extends IService<XdUserInfo> {
    /**
     * 根据用户id获取用户详情介绍表信息
     */
    XdUserInfo getUserInfoById(Long id);

    /**
     * 保存用户详情介绍表信息
     */
    XdUserInfo saveUserInfo(XdUserInfoParams xdUserInfoParams);
}
