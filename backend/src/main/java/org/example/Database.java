package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Component
public class Database {
    private Map<String, User> loginInfor = new HashMap<>();

    Database() {
        loginInfor.put("admin", new User("admin", 123));
        loginInfor.put("Ying", new User("Ying", 123456));
        loginInfor.put("Kate", new User("Kate", 456789));
    }

    public Integer getPassword(String userName) {
        User user = loginInfor.get(userName);
        if (user == null) {
            return null;
        }
        return user.getPassword();
    }
}
