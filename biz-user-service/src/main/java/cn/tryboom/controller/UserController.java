package cn.tryboom.controller;

import cn.tryboom.biz.api.interfaces.UserService;
import cn.tryboom.biz.api.model.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {


    @Override
    public Boolean saveUser(User user) {
        System.out.println("user-service save user : " + user.toString());
        return Boolean.TRUE;
    }
}
