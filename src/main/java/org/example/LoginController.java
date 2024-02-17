package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LoginController {

    @CrossOrigin(origins = "*") // 允许所有源的CORS请求
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 这里应该添加真实的用户验证逻辑
        if (checkUser01(user)) {
            return "{\"result\": \"Login successful\"}";
        } else {
                return "{\"result\": \"Invalid username or password\"}";
        }
    }

    public boolean checkUser01(User user) {
        if ("admin".equals(user.getUsername()) && 123 == user.getPassword()) {
            return true;
        } else {
            return false;
        }
    }
    Boolean checkPassword02(String userName, int password) {
        LoginInfor loginInfor = new LoginInfor();
        ArrayList<User> loginUser = loginInfor.getLoginInfor();
        for (User user : loginUser) {
            if (userName.equals(user.getUsername()) && isValidPwd(password) && password == user.getPassword()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // int range -2147483648 to 2147483647
    static Boolean isValidPwd(int password) {
        if (password > 100000 && password < 999999) {
            return true;
        } else {
            return false;
        }
    }
}

