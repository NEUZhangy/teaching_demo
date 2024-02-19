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
        if (checkUser02(user)) {
            return "{\"result\": \"Login successful\"}";
        } else {
                return "{\"result\": \"Invalid username or password\"}";
        }
    }


    public Boolean checkUser02(User2 user) {
        //the username and password should not be null
        if (user == null) {
            return false;
        }
        String userName = user.getUsername();
        String password = user.getPassword();
        if(userName == null || password == null) {
            return false;
        }

        if (isValidPwd(password) && db.getPassword(userName) != null
                && password.equals(db.getPassword(userName).toString())) {
            return true;
        } else {
            return false;
        }
    }

    // int range > 3  to  < 7
    static Boolean isValidPwd(String password) {
        if (password.length() >= 3 && password.length() < 7) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUser01(User2 user) {
        if (user.getPassword().equals(db.getPassword(user.getUsername()).toString())) {
            return true;
        } else {
            return false;
        }
    }
}

