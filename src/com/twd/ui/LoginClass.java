package com.twd.ui;

import com.twd.bean.User;
import com.twd.service.UserService;
import com.twd.utils.BusinessException;

/**
 * @Classname LoginClass
 * @Date 2019/4/21 14:10
 * @Created by Administrator
 */
public class LoginClass extends BaseClass{
    private UserService userService;
    public  LoginClass(){
        userService = ((UserService) beanFactory.getBean("userService"));
    }
    public void login() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user = userService.login(username, password);
        if (user!=null){
            currUser = user;
        }else{
            throw new BusinessException("login.error");
        }
    }
}
