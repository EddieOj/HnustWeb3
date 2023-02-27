package com.lixna.sgninsys.exception;


import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 处理自定义异常
     */
            @ExceptionHandler(value = RRException.class)
            public R handleRRException(RRException e){
                return R.failed(e.getMsg());
            }

    @ExceptionHandler(value = AccountException.class)
    public R handleAccountException(AccountException e){
        return R.failed(e.getMessage());
    }

    /**
     * 捕捉UnauthorizedException
     *
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public R handle401(UnauthorizedException e) {
        log.error("UnauthorizedException：", e);
        return R.failed("权限不够");
    }

    @ExceptionHandler(AuthorizationException.class)
    public R handle402(AuthorizationException e) {
        log.error("权限不够：", e);
        return R.failed("权限不够");
    }

    /**
     * 捕捉shiro的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public R handler(ShiroException e) {
        log.error("ShiroException：", e);
        return R.failed(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public R handler(RuntimeException e){
        log.error("运行时异常"+e.getMessage());
        return R.failed("服务器出问题了");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return R.failed("数据库中已存在该记录,有重复字段");
    }
}
