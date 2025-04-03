package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/Checkout")
public class CheckoutController {

    private final Database db;

    CheckoutController(Database _db) {
        db = _db;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addItem")
    @ResponseBody
    public ResponseEntity<?> CartResponse(@RequestBody CartItemRequest cartItemRequest) {
        Cart cart = new Cart();

        String productName = cartItemRequest.getName();
        int quantity = cartItemRequest.getQuantity();
        // Check if product exists
        Optional<Product> productOpt = db.getProduct(productName);
        if (!productOpt.isPresent()) {
            // Return error response if product doesn't exist
            return ResponseEntity.badRequest().body(
                    "Product not found"
            );
        }
        double price = productOpt.get().getPrice();

        Product product = new Product(productName, price);
        cart.addItem(new Item(product, quantity));

        Map<String, Object> response = new HashMap<>();
        response.put("cartItems", cart.getCartItems());
        response.put("total", cart.getTotal());

        return ResponseEntity.ok(response);
    }
}

