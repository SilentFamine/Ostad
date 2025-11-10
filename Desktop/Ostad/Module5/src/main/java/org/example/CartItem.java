package org.example;

import java.util.UUID;

public class CartItem {
    private final String productId;  // immutable unique id
    private final String name;       // immutable
    private final double unitPrice;  // immutable
    private int quantity;


    public CartItem(String name, double unitPrice, int quantity) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be greater than 0.");
        }
        this.unitPrice = unitPrice;
        this.quantity = Math.max(quantity, 0); // Ensure non-negative
    }


    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }


    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        if (quantity > 1) {
            quantity--;
        } else {
            System.out.println("Quantity cannot be less than 1!");
        }
    }


    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return String.format("%s | Price: %.2f | Quantity: %d | Subtotal: %.2f",
                name, unitPrice, quantity, unitPrice * quantity);
    }
}
