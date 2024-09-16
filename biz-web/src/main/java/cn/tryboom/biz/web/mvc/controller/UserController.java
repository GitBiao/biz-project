package cn.tryboom.biz.web.mvc.controller;

import cn.tryboom.biz.api.interfaces.UserService;
import cn.tryboom.biz.api.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        Boolean saved = userService.saveUser(user);
        if(saved){
            return "user saved" + user.toString();
        }
        return "user not saved";
    }
}
