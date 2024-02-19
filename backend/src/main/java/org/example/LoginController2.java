package org.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController2 {

    private final Database db;

    LoginController2(Database _db) {
        db = _db;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/loginString")
    public String login(@RequestBody User2 user) {
        if (checkUser01(user)) {
            return "{\"result\": \"Login successful\"}";
        } else {
                return "{\"result\": \"Invalid username or password\"}";
        }
    }

    public boolean checkUser01(User2 user) {
        if (user.getPassword().equals(db.getPassword(user.getUsername()).toString())) {
            return true;
        } else {
            return false;
        }
    }
    Boolean checkPassword02(String userName, String password) {
        if (isValidPwd(password) && password.equals(db.getPassword(userName).toString())) {
            return true;
        } else {
            return false;
        }
    }

    // int range > 3  to  < 7
    static Boolean isValidPwd(String password) {
        if (password.length() > 3 && password.length() < 7) {
            return true;
        } else {
            return false;
        }
    }
}

