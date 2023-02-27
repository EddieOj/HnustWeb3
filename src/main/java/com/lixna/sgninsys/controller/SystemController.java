package com.lixna.sgninsys.controller;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.config.jwt.CustomToken;
import com.lixna.sgninsys.config.jwt.JwtConst;
import com.lixna.sgninsys.config.jwt.JwtUtil;
import com.lixna.sgninsys.entity.LoginType;
import com.lixna.sgninsys.entity.User;
import com.lixna.sgninsys.entity.vo.UserDto;
import com.lixna.sgninsys.exception.RRException;
import com.lixna.sgninsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: SystemController
 * @Auther: sln
 * @Date: 2021/04/22/14:32
 * @Description:
 */
@RestController
@Slf4j
@CrossOrigin
@Api(tags = "系统模块")
@RequestMapping("/sgninsys/sys")
public class SystemController {
    @Resource
    UserService userService;

    /**
     * 登录
     */
    @ApiOperation(value = "用户登陆", notes = "参数:电话 密码")
    @PostMapping("/login")
    public R login(@Valid @RequestBody UserDto loginDTO) {
        String phone = loginDTO.getPhone();
        String password = loginDTO.getPassword();
        CustomToken token = new CustomToken(phone, password, LoginType.USER);
        return shiroLogin(token);

    }

    //shiro的登录
    public R shiroLogin(CustomToken token) {
        try {
            //查找user
            String jwtToken = JwtUtil.createToken(token.getUsername(), JwtConst.SECRET);
            String password = "";
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("phone", token.getUsername());
            User user = userService.getOne(wrapper);
            if (user == null) {
                return R.error().message("登录失败，用户名不存在");
            }
            //验证密码
            password = user.getPassword();
            byte[] key = String.valueOf(token.getPassword()).getBytes();
            HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);
            String validatePassword = mac.digestHex(String.valueOf(token.getPassword()));
            System.out.println(validatePassword);
//            System.out.println(String.valueOf(token.getPassword()));
            if (password.equals(validatePassword)) {
                return R.ok().data("touser_idken", jwtToken)
                        .data("user_id", user.getUserId())
                        .data("phone", user.getPhone())
                        .data("real_name", user.getRealName())
                        .message("登录成功");
            } else {
                return R.error().message("登录失败，密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException("查询数据库失败");
        }
    }
    @ApiOperation(value = "用户注册", notes = "参数:电话 密码")
    @PostMapping("/register")
    public R register(@Valid @RequestBody UserDto loginDTO) {
        String phone = loginDTO.getPhone();
        String password = loginDTO.getPassword();
        //查看电话重复
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phone);
        User checkUser = userService.getOne(wrapper);

        if (checkUser == null) {
            byte[] key = password.getBytes();
            HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);
            String validatePassword = mac.digestHex(password);
            if(phone != "" && password!=""){
                User user = new User();
                user.setPhone(phone);
                user.setPassword(validatePassword);
                userService.save(user);
            }else {
                return R.error().message("电话和密码不能为空！");
            }
            return R.ok();
        }else{
            return R.error().message("该用户已存在！");
        }
    }
}
