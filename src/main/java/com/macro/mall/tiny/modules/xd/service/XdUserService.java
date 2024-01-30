package com.macro.mall.tiny.modules.xd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.xd.dto.XdUserParams;
import com.macro.mall.tiny.modules.xd.model.XdUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户基本信息表 服务类
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
public interface XdUserService extends IService<XdUser> {
    /**
     * 注册心动用户信息
     *
     * @author fuwenhao
     * @createDate 2024/1/30 16:18
     * @Description
     **/
    XdUser registryUser(XdUserParams xdUserParams);

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return com.macro.mall.tiny.modules.xd.model.XdUser
     * @throws
     * @since 2024/1/30 16:18
     */
    XdUser getUserById(Long id);

    /**
     * 更新用户信息
     *
     * @param xdUser
     * @return com.macro.mall.tiny.modules.xd.model.XdUser
     * @throws
     * @since 2024/1/30 16:18
     */
    boolean updateUser(XdUser xdUser);

    /**
     * 删除用户信息
     *
     * @param id
     * @return com.macro.mall.tiny.modules.xd.model.XdUser
     * @throws
     * @since 2024/1/30 16:18
     */
    boolean deleteUser(Long id);

    /**
     * 分页查询用户信息
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.macro.mall.tiny.modules.xd.model.XdUser>
     * @throws
     * @since 2024/1/30 16:18
     */
    Page<XdUser> pageUser(String keyword, Integer pageNum, Integer pageSize);
}