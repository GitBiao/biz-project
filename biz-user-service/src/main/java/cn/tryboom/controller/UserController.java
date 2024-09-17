package cn.tryboom.controller;

import cn.tryboom.biz.api.interfaces.UserService;
import cn.tryboom.biz.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController implements UserService {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public Boolean saveUser(User user) {
        logger.info("user-service save user : {} " , user.toString());
        return Boolean.TRUE;
    }
}
