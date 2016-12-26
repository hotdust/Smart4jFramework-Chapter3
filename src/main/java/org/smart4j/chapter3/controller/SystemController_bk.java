package org.smart4j.chapter3.controller;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.config.IniSecurityManagerFactory;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.util.Factory;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.smart4j.framework.annotation.Action;
//import org.smart4j.framework.annotation.Controller;
//import org.smart4j.framework.bean.Param;
//import org.smart4j.framework.bean.View;
//import org.smart4j.framework.helper.ServletHelper;
//
///**
// * Created by shijiapeng on 16/12/20.
// */
//@Controller
//public class SystemController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);
//
//    @Action("get:/")
//    public View index() {
//        return new View("index.jsp");
//    }
//
//    @Action("get:/login")
//    public View login() {
//        return new View("login.jsp");
//    }
//
////    @Action("post:/login")
////    public View loginSubmit(Param param) {
////        String username = param.getString("username");
////        String password = param.getString("password");
////
////        Subject subject = SecurityUtils.getSubject();
////        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
////        try {
////            subject.login(usernamePasswordToken);
////        } catch (AuthenticationException e) {
////            LOGGER.error("login Authentication failuer", e);
////            return new View("/login.jsp");
////        } finally {
////        }
////        return new View("/customer");
////    }
//
//    @Action("post:/login")
//    public View loginSubmit(Param param) {
//
//
//        String errorClassName = (String) ServletHelper.getRequestAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
//        if(UnknownAccountException.class.getName().equals(errorClassName)) {
//            ServletHelper.setRequestAttribute("error", "用户名/密码错误");
//        } else if(IncorrectCredentialsException.class.getName().equals(errorClassName)) {
//            ServletHelper.setRequestAttribute("error", "用户名/密码错误");
//        } else if(errorClassName != null) {
//            ServletHelper.setRequestAttribute("error", "未知错误：" + errorClassName);
//        }
//
//        return new View("/customer_edit?id=1");
//    }
//
//    @Action("get:/logout")
//    public View logout() {
//        SecurityUtils.getSubject().logout();
//        return new View("/login");
//    }
//
//}
