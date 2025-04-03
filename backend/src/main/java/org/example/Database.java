package org.example;


// this is mock db

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class Database {
    private Map<String, User> loginInfor = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();

    Database() {
        loginInfor.put("admin", new User("admin", 123));
        loginInfor.put("Ying", new User("Ying", 123456));
        loginInfor.put("Kate", new User("Kate", 456789));

        products.put("Apple", new Product("Apple", 1.0));
        products.put("Banana", new Product("Banana", 2.2));
    }

    public Integer getPassword(String userName) {
        User user = loginInfor.get(userName);
        if (user == null) {
            return null;
        }
        return user.getPassword();
    }

    public Optional<Product> getProduct(String productName) {
        return Optional.ofNullable(products.get(productName));
    }
}
