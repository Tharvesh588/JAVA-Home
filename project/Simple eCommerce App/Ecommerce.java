import java.util.*;

public class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Smart Watch", 3000));
        products.add(new Product("Keyboard", 800));
        products.add(new Product("Monitor", 15000));
        products.add(new Product("Bluetooth Speaker", 1500));
        products.add(new Product("External Hard Drive", 2500));
        products.add(new Product("Wireless Headphones", 3500));
        products.add(new Product("Webcam", 1000));
        products.add(new Product("USB-C Cable", 150));
        products.add(new Product("Charger Adapter", 500));
        products.add(new Product("Tablet", 7000));

        ArrayList<Product> cart = new ArrayList<>();

        String name, password;
        boolean valid = false;
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Username: ");
            name = sc.nextLine();

            System.out.print("Password: ");
            password = sc.nextLine();

            User user = new User(name, password);
            valid = user.valid();

            if (valid) {
                break;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Invalid user & password. Attempts left: " + attempts);
                } else {
                    System.out.println("Too many failed attempts. Exiting.");
                    sc.close();
                    return;
                }
            }
        }

        int choice;
        while (valid) {
            System.out.println("\nWelcome to Gadget Guru!");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nProduct List:");
                    for (int i = 0; i < products.size(); i++) {
                        Product p = products.get(i);
                        System.out.println((i + 1) + ". " + p.name + " - Rs. " + p.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter product numbers to add to cart (space-separated): ");
                    String input = sc.nextLine();
                    String[] selectedProducts = input.split(" ");

                    for (String productNum : selectedProducts) {
                        try {
                            int num = Integer.parseInt(productNum);
                            if (num >= 1 && num <= products.size()) {
                                Product p = products.get(num - 1);
                                cart.add(p);
                                System.out.println(p.name + " added to cart.");
                            } else {
                                System.out.println("Invalid product number: " + num);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter numbers separated by spaces.");
                        }
                    }
                    break;

                case 3:

                    printBill(cart);

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                        break;
                    }

                    double totalAmount = printBill(cart);

                    System.out.print("Enter payment amount: ");
                    double pay = sc.nextDouble();

                    if (pay == totalAmount) {
                        cart.clear();
                        System.out.println("Thanks for your purchase!");
                    } else {
                        System.out.println("Invalid amount, please pay Rs. " + totalAmount);
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    valid = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        sc.close();

    }

    public static double printBill(ArrayList<Product> cart) {
        double totalAmount = 0;

        System.out.println("----- Bill -----");
        System.out.printf("%-20s %-10s\n", "Product Name", "Price");

        for (Product pItem : cart) {
            System.out.printf("%-20s %-10.2f\n", pItem.name, pItem.price);
            totalAmount += pItem.price;
        }

        System.out.println("----------------------");
        System.out.printf("%-20s %-10.2f\n", "Total Amount", totalAmount);

        return totalAmount;
    }

}

class Product {
    String name;
    double price;

    Product(String n, double p) {
        name = n;
        price = p;
    }
}

class User {
    private String username;
    private String password;

    User(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    boolean valid() {
        return (!username.isEmpty()) && (!password.isEmpty()) && (password.length() <= 6);

    }
}
