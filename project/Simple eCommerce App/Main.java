import java.util.ArrayList;
import java.util.Scanner;

class User {
    String username;
    String password;
    String name;
    String email;
    String address;

    User(String username, String password, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    boolean validate(String uname, String pass) {
        return this.username.equals(uname) && this.password.equals(pass);
    }
}

class Product {
    String name;
    double price;
    String description;
    String brand;
    double rating;
    int stock;

    Product(String name, double price, String description, String brand, double rating, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.rating = rating;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10.2f %-20s %-10s %-5.1f %d", name, price, description, brand, rating, stock);
    }
}

public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    static User admin = new User("admin", "admin@tm", "Admin", "admin@tm.com", "Admin Address");

    public static void main(String[] args) {
        users.add(admin);
        products.add(new Product("Smart Watch", 3000, "A stylish smartwatch", "TechBrand", 4.5, 10));
        products.add(new Product("Keyboard", 800, "Wireless keyboard", "KeyMaker", 4.0, 15));
        products.add(new Product("Monitor", 15000, "High resolution monitor", "ViewMax", 4.7, 5));
        products.add(new Product("Bluetooth Speaker", 1500, "Portable Bluetooth speaker", "SoundPro", 4.2, 8));
        products.add(new Product("External Hard Drive", 2500, "1TB storage", "DriveTech", 4.3, 12));

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        User loggedInUser = null;

        while (running) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    loggedInUser = loginUser(sc);
                    if (loggedInUser != null) {
                        System.out.println("Login successful! Welcome.");
                        showMenu(sc, loggedInUser);
                    } else {
                        System.out.println("Invalid credentials. Try again.");
                    }
                    break;
                default:
                    running = false;
                    System.out.println("Goodbye!");
            }
        }
        sc.close();
    }

    private static void registerUser(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        users.add(new User(username, password, name, email, address));
        System.out.println("Registration successful!");
    }

    private static User loginUser(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (username.equals(admin.username) && password.equals(admin.password)) {
            return admin;
        }

        for (User user : users) {
            if (user.validate(username, password)) {
                return user;
            }
        }
        return null;
    }

    private static void showMenu(Scanner sc, User loggedInUser) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\nWelcome to Gadget Guru!");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Logout");

            if (isAdmin(loggedInUser)) {
                System.out.println("6. View All Users");
                System.out.println("7. Add New Product");
                System.out.println("8. Remove Product");
            }

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
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
                    addToCart(sc);
                    break;

                case 3:
                    printBill(cart);
                    break;

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
                    inMenu = false;
                    break;

                case 6:
                    if (isAdmin(loggedInUser)) {
                        viewAllUsers();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 7:
                    if (isAdmin(loggedInUser)) {
                        addNewProduct(sc);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 8:
                    if (isAdmin(loggedInUser)) {
                        removeProduct(sc);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static boolean isAdmin(User loggedInUser) {
        return loggedInUser.username.equals(admin.username);
    }

    private static void viewAllUsers() {
        System.out.println("List of all registered users:");
        for (User user : users) {
            System.out.println("========================================");
            System.out.println("Username: " + user.username);
        }
    }

    private static void addNewProduct(Scanner sc) {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter product description: ");
        String description = sc.nextLine();

        System.out.print("Enter product brand: ");
        String brand = sc.nextLine();

        System.out.print("Enter product rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter product stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        products.add(new Product(name, price, description, brand, rating, stock));
        System.out.println("Product added successfully!");
    }

    private static void removeProduct(Scanner sc) {
        System.out.println("Product List:");
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.name + " - Rs. " + p.price);
        }

        System.out.print("Enter product number to remove: ");
        int productNum = sc.nextInt();
        sc.nextLine();

        if (productNum >= 1 && productNum <= products.size()) {
            products.remove(productNum - 1);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Invalid product number.");
        }
    }

    private static void addToCart(Scanner sc) {
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
