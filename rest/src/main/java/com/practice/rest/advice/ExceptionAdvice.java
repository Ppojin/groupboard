package com.practice.rest.advice;

import com.practice.rest.advice.exception.CEmailSigninFailedException;
import com.practice.rest.advice.exception.CUserNotFoundException;
import com.practice.rest.advice.exception.CAuthenticationEntryPointException;
import com.practice.rest.model.response.CommonResult;
import com.practice.rest.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {
    private final ResponseService responseService;
    private final MessageSource messageSource;

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected CommonResult defaultException(HttpServletRequest request, Exception e){
//        return responseService.getFailResult();
//    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(
            HttpServletRequest request,
            Exception e){
        return responseService.getFailResult(
                Integer.parseInt(getMessage("unKnown.code")),
                getMessage("unKnown.msg")
        );
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(
            HttpServletRequest request,
            CUserNotFoundException e){
        return responseService.getFailResult(
                Integer.parseInt(getMessage("userNotFound.code")),
                getMessage("userNotFound.msg")
        );
    }

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult emailSigninFailed(
            HttpServletRequest request,
            CEmailSigninFailedException e){
        return responseService.getFailResult(
                Integer.parseInt(getMessage("emailSigninFailed.code")),
                getMessage("emailSigninFailed.msg")
        );
    }
    @ExceptionHandler(CAuthenticationEntryPointException.class)
    public CommonResult authenticationEntryPointException(
            HttpServletRequest request,
            CAuthenticationEntryPointException e) {
        return responseService.getFailResult(
                Integer.parseInt(getMessage("entryPointException.code")),
                getMessage("entryPointException.msg")
        );
    }

    private String getMessage(String code){
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args){
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public CommonResult AccessDeniedException(
            HttpServletRequest request,
            AccessDeniedException e ){
        return responseService.getFailResult(
                Integer.parseInt(getMessage("accessDenied.code")),
                getMessage("accessDenied.msg")
        );
    }
}
