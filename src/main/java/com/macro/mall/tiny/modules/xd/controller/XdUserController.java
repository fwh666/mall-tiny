package com.macro.mall.tiny.modules.xd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.xd.dto.XdUserParams;
import com.macro.mall.tiny.modules.xd.model.XdUser;
import com.macro.mall.tiny.modules.xd.service.XdUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户基本信息表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2024-01-30
 */
@Tag(name = "XdUserController", description = "心动用户基本信息管理")
@RestController
@RequestMapping("/xd/xdUser")
public class XdUserController {
    @Autowired
    private XdUserService xdUserService;

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @Operation(summary = "注册心动用户信息")
    @PostMapping("/registryUser")
    public CommonResult<XdUser> registryUser(@RequestBody XdUserParams xdUserParams) {
        XdUser xdUser = xdUserService.registryUser(xdUserParams);
        if (xdUser == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(xdUser);
    }

    @Operation(summary = "根据用户id获取用户信息")
    @GetMapping("/getUserById")
    public CommonResult<XdUser> getUserById(@RequestParam("id") Long id) {
        XdUser xdUser = xdUserService.getUserById(id);
        if (xdUser == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(xdUser);
    }

    @Operation(summary = "更新用户信息")
    @PostMapping("/updateUser/{id}")
    public CommonResult<XdUser> updateUser(@PathVariable Long id, @RequestBody XdUser xdUser) {
        xdUser.setId(id);
        boolean success = xdUserService.updateUser(xdUser);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "删除用户信息")
    @PostMapping("/deleteUser")
    public CommonResult deleteUser(@RequestParam("id") Long id) {
        boolean success = xdUserService.deleteUser(id);
        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @Operation(summary = "分页获取用户信息")
    @GetMapping("/pageUser")
    public CommonResult<CommonPage<XdUser>> listUser(@RequestParam(value = "keyword", required = false) String keyword,
                                                     @RequestParam("pageNum") Integer pageNum,
                                                     @RequestParam("pageSize") Integer pageSize) {
        Page<XdUser> xdUserPage = xdUserService.pageUser(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(xdUserPage));

    }


}
