package com.lixna.sgninsys.config.jwt;

import com.lixna.sgninsys.config.jwt.JwtUtil;
import com.lixna.sgninsys.entity.LoginType;
import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: CustomToken
 * @Auther: sln
 * @Date: 2021/06/21/19:05
 * @Description:
 */
@Data
public class CustomToken extends UsernamePasswordToken {

    //定义登陆的类型是为了在后面的校验中 去选择使用哪一个realm
    private LoginType loginType;

    private String token;
    @Override
    public Object getPrincipal() {
        return this.getUsername();
    }

    @Override
    public Object getCredentials() {
        return token;
    }
    public CustomToken(String userName, String password, LoginType loginType){
        super(userName,password);
        this.loginType=loginType;
    }
    public CustomToken(String token,String loginType){
        this.loginType= LoginType.valueOf(loginType);
        this.setUsername(JwtUtil.getUsername(token, "username")) ;
        this.token=token;
    }
    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public LoginType getLoginType() {
        return loginType;
    }
}
