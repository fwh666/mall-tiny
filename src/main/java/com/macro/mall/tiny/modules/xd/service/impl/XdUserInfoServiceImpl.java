package com.macro.mall.tiny.modules.xd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macro.mall.tiny.modules.xd.dto.XdUserInfoParams;
import com.macro.mall.tiny.modules.xd.model.XdUser;
import com.macro.mall.tiny.modules.xd.model.XdUserInfo;
import com.macro.mall.tiny.modules.xd.mapper.XdUserInfoMapper;
import com.macro.mall.tiny.modules.xd.service.XdUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户详情介绍表
 * 服务实现类
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Service
public class XdUserInfoServiceImpl extends ServiceImpl<XdUserInfoMapper, XdUserInfo> implements XdUserInfoService {

    @Override
    public XdUserInfo getUserInfoById(Long id) {
        return baseMapper.selectOne(new QueryWrapper<XdUserInfo>().lambda().eq(XdUserInfo::getId, id));
    }

    @Override
    public XdUserInfo saveUserInfo(XdUserInfoParams params) {
        XdUserInfo xdUserInfo = new XdUserInfo();
        BeanUtils.copyProperties(params, xdUserInfo);
        xdUserInfo.setCreateTime(new Date()).setUpdateTime(new Date());
        baseMapper.insert(xdUserInfo);
        return xdUserInfo;
    }
}
