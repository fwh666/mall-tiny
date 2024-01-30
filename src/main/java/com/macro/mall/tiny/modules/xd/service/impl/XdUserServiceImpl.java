package com.macro.mall.tiny.modules.xd.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.xd.dto.XdUserParams;
import com.macro.mall.tiny.modules.xd.enums.DeleteEnum;
import com.macro.mall.tiny.modules.xd.model.XdUser;
import com.macro.mall.tiny.modules.xd.mapper.XdUserMapper;
import com.macro.mall.tiny.modules.xd.service.XdUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Service
public class XdUserServiceImpl extends ServiceImpl<XdUserMapper, XdUser> implements XdUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String defaultPassword = "fuwenhao";

    @Override
    public XdUser registryUser(XdUserParams xdUserParams) {
        XdUser xdUser = new XdUser();
        BeanUtils.copyProperties(xdUserParams, xdUser);
        xdUser.setPassword(passwordEncoder.encode(defaultPassword));
        xdUser.setUid(getUid());
        xdUser.setCreateTime(new Date()).setUpdateTime(new Date());
        baseMapper.insert(xdUser);
        return xdUser;
    }


    /**
     * 生成八位UID随机数
     *
     * @return
     */
    public static String getUid() {
        String uid = "";
        for (int i = 0; i < 8; i++) {
            uid += (int) (Math.random() * 10);
        }
        return "U" + uid;
    }

    @Override
    public XdUser getUserById(Long id) {
        XdUser xdUser = baseMapper.selectOne(new QueryWrapper<XdUser>().lambda().eq(XdUser::getId, id));
        return xdUser;
    }

    @Override
    public boolean updateUser(XdUser xdUser) {
        XdUser rawUser = getById(xdUser.getId());
        if (rawUser.getPassword().equals(xdUser.getPassword())) {
            //与原加密密码相同的不需要修改
            xdUser.setPassword(null);
        } else {
            //与原加密密码不同的需要加密修改
            if (StrUtil.isEmpty(xdUser.getPassword())) {
                xdUser.setPassword(null);
            } else {
                xdUser.setPassword(passwordEncoder.encode(xdUser.getPassword()));
            }
        }
        boolean success = updateById(xdUser);
//        getCacheService().delAdmin(id);
        return success;
    }

    @Override
    public boolean deleteUser(Long id) {
//        getCacheService().delAdmin(id);
//        boolean success = removeById(id);
        XdUser xdUser = new XdUser();
        xdUser.setId(id).setDeleted(true);
        boolean success = updateById(xdUser);
//        getCacheService().delResourceList(id);
        return success;
    }

    @Override
    public Page<XdUser> pageUser(String keyword, Integer pageNum, Integer pageSize) {
        Page<XdUser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<XdUser> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<XdUser> lambda = wrapper.lambda();
        lambda.eq(XdUser::getDeleted, DeleteEnum.NOT_DELETE.getCode());
        if (StrUtil.isNotEmpty(keyword)) {
            lambda.like(XdUser::getUserName, keyword);
//            lambda.or().like(XdUser::getNickName,keyword);
        }
        return page(page, wrapper);
    }
}
