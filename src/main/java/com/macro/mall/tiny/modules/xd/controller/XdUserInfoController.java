package com.macro.mall.tiny.modules.xd.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.xd.dto.XdUserInfoParams;
import com.macro.mall.tiny.modules.xd.model.XdUserInfo;
import com.macro.mall.tiny.modules.xd.service.XdUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户详情介绍表
 * 前端控制器
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@RestController
@RequestMapping("/xd/xdUserInfo")
public class XdUserInfoController {

    @Autowired
    private XdUserInfoService xdUserInfoService;

    @Operation(summary = "根据用户id获取用户详情介绍表信息")
    @RequestMapping("/getUserInfoById")
    public CommonResult<XdUserInfo> getUserInfoById(@RequestParam("id") Long id) {

        return CommonResult.success(xdUserInfoService.getUserInfoById(id));
    }

    @Operation(summary = "保存用户详情介绍表信息")

    @RequestMapping("/saveUserInfo")
    public CommonResult saveUserInfo(@RequestBody XdUserInfoParams params) {
        return CommonResult.success(xdUserInfoService.saveUserInfo(params));
    }

}
