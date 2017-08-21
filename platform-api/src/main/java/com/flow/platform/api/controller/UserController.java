package com.flow.platform.api.controller;

import com.flow.platform.api.domain.User;
import com.flow.platform.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liangpengyv
 */

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index() {
        return "Hello, please login!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (user.getEmail() == null) {
            // Use user_name to login
            return userService.loginByUserName(user.getUserName(), user.getPassword());
        } else {
            // Use email to login
            return userService.loginByEmail(user.getEmail(), user.getPassword());
        }

    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("delete_user")
    public String deleteUser(@RequestBody User[] users) {
        String msg = "[";
        for (User user : users) {
            msg += userService.deleteUser(user) + ",";
        }
        msg = msg.substring(0, msg.length() - 1) + "]";
        return msg;
    }
}
