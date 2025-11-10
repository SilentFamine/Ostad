package org.example;
import java.util.*;

public class Main {
    private static final List<CartItem> cart = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        CartItem egg = new CartItem("Egg", 10, 0);
        CartItem milk = new CartItem("Milk", 20, 0);
        CartItem noodles = new CartItem("Noodles", 30, 0);


        while (true) {
            System.out.println("\n=========Shopping Cart Menu =========");
            System.out.println("1. Add Egg");
            System.out.println("2. Add Milk");
            System.out.println("3. Add Noodles");
            System.out.println("5. Increment item quantity");
            System.out.println("6. Decrement item quantity");
            System.out.println("7. Show Cart");
            System.out.println("8. Show Total Payable Amount");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addToCart(egg);
                case 2 -> addToCart(milk);
                case 3 -> addToCart(noodles);
                case 5 -> changeQuantity(true);
                case 6 -> changeQuantity(false);
                case 7 -> showCart();
                case 8 -> showTotal();
                case 0 -> {
                    System.out.println("🛒 Exiting... Thank you for shopping!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }


    private static void addToCart(CartItem item) {
        for (CartItem c : cart) {
            if (c.getProductId().equals(item.getProductId())) {
                c.incrementQuantity();
                System.out.println("Added one more " + c.getName());
                return;
            }
        }
        item.setQuantity(1);
        cart.add(item);
        System.out.println( item.getName() + " added to cart.");
    }


    private static void changeQuantity(boolean increment) {
        if (cart.isEmpty()) {
            System.out.println("🛒 Cart is empty!");
            return;
        }
        showCart();
        System.out.print("Enter product name to update: ");
        String name = scanner.next();

        for (CartItem item : cart) {
            if (item.getName().equalsIgnoreCase(name)) {
                if (increment) item.incrementQuantity();
                else item.decrementQuantity();
                System.out.println("Quantity updated for " + item.getName());
                return;
            }
        }
        System.out.println("Item not found in cart!");
    }


    private static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("🛒 Your cart is empty!");
            return;
        }
        System.out.println("\n------ CART ITEMS ------");
        for (CartItem item : cart) {
            System.out.println(item);
        }
    }


    private static void showTotal() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        System.out.printf("Total Payable: %.2f\n", total);
    }
}
