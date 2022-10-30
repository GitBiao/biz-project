package cn.tryboom.biz.web.mvc.controller;

import cn.tryboom.biz.api.interfaces.UserService;
import cn.tryboom.biz.api.model.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {
    @Override
    public Boolean saveUser(User user) {
        return Boolean.TRUE;
    }
}
