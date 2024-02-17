package org.example;

import java.util.ArrayList;

public class LoginInfor {

    ArrayList<User> loginInfor = new ArrayList<User>();
    LoginInfor() {
        loginInfor.add(new User("admin", 123));
        loginInfor.add(new User("Ying", 123456));
        loginInfor.add(new User("Kate", 456789));
    }

    public ArrayList<User> getLoginInfor() {
        return loginInfor;
    }
}
