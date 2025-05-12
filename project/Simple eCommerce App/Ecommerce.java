import java.util.*;

public class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 5000));
        products.add(new Product("Laptop", 10000));
        products.add(new Product("Mouse", 600));
        products.add(new Product("32GB Master", 700));
        products.add(new Product("64GB  Master", 1200));

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
                    System.out.print("Enter product number to add to cart: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    if (num >= 1 && num <= products.size()) {
                        Product p = products.get(num - 1);
                        cart.add(p);
                        System.out.println(p.name + " added to cart.");
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 3:
                    System.out.println("\nYour Cart:");
                    double total = 0;
                    for (Product pItem : cart) {
                        System.out.println("- " + pItem.name + " - Rs. " + pItem.price);
                        total += pItem.price;
                    }
                    System.out.println("Total: Rs. " + total);
                    break;

                case 4:
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                        break;
                    }

                    double totalAmount = 0;
                    for (Product pItem : cart) {
                        totalAmount += pItem.price;
                    }

                    System.out.print("Total amount: Rs. " + totalAmount + ". Enter payment amount: ");
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
                    valid = false; // or use break with a labeled loop if needed
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        sc.close();

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
