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
        
        int choice;

        while (true) {
            System.out.println("\nWelcome to Gadget Guru!");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\nProduct List:");
                for (int i = 0; i < products.size(); i++) {
                    Product p = (Product) products.get(i);
                    System.out.println((i + 1) + ". " + p.name + " - Rs. " + p.price);
                }

            } else if (choice == 2) {
                System.out.print("Enter product number to add to cart: ");
                int num = sc.nextInt();
                sc.nextLine();

                if (num >= 1 && num <= products.size()) {
                    Product p = (Product) products.get(num - 1);
                    cart.add(p);
                    System.out.println(p.name + " added to cart.");
                } else {
                    System.out.println("Invalid product number.");
                }

            } else if (choice == 3) {
                System.out.println("\nYour Cart:");
                double total = 0;
                for (int i = 0; i < cart.size(); i++) {
                    Product p = (Product) cart.get(i);
                    System.out.println("- " + p.name + " - Rs. " + p.price);
                    total += p.price;
                }
                System.out.println("Total: Rs. " + total);

            } else if (choice == 4) {
                if (cart.size() == 0) {
                    System.out.println("Cart is empty.");
                } else {
                    cart.clear();
                    System.out.println("Checkout complete. Thank you!");
                }

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
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
