package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    private final Database db;

    LoginController(Database _db) {
        db = _db;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (checkUser01(user)) {
            return "{\"result\": \"Login successful\"}";
        } else {
                return "{\"result\": \"Invalid username or password\"}";
        }
    }

    public boolean checkUser01(User user) {
//        if (user == null) {
//            return false;
//        }
        if (user.getPassword() == db.getPassword(user.getUsername())) {
            return true;
        } else {
            return false;
        }
    }
    Boolean checkPassword02(String userName, int password) {
        if (isValidPwd(password) && password == db.getPassword(userName)) {
            return true;
        } else {
            return false;
        }
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

