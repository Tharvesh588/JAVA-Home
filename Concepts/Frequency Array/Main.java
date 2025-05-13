import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Size of Array: ");
        int size = s.nextInt();
        // -------------------------------------------------------------
        int a[] = new int[size];
        int c[] = new int[size*100];

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " Element: ");
            a[i] = s.nextInt(); 
        }

        System.out.print("Elements are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] +", ");
        }

        for (int i = 0; i < size; c[a[i]]++, i++);
        // -------------------------------------------------------------
        System.out.println(" ");
        System.out.println("1. Unique Elements");
        System.out.println("2. Duplicate Elements");
        System.out.println("3. Non Repeating Elements / Assending Order");
        System.out.println("4. Least Missing Number");
        System.out.println("5. Kth Elements");
        System.out.println("6. occurance Sorting");
        System.out.println(" ");

        System.out.print("Enter the operation (1-6):");
        // ------------------------------------------------------------------
        int ch = s.nextInt();
        System.out.println(" ");

        switch (ch) {
            case 1:
                System.out.print("Unique Elements: ");
                for (int i = 0; i < 1000; i++) {
                    if (c[i] == 1) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case 2:
                System.out.print("Duplicate Elements: ");
                for (int i = 0; i < 1000; i++) {
                    if (c[i] > 1) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case 3:
                System.out.println("Non Repeating Elements / Assending Order: ");
                for (int i = 0; i < 1000; i++) {
                    if (c[i] > 0) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case 4:
                System.out.print("Least Missing Number: ");
                for (int i = 1; i < 1000; i++) {
                    if (c[i] == 0) {
                        System.out.print(i + " ");
                        break;
                    }
                }
                break;
            case 5:
                System.out.print("Enter the Postion: ");
                int k = s.nextInt();

                System.out.print("Kth Element: ");
                for (int i = 1, n = 1; i < 1000; i++) {
                    if (n == k && c[i] == 0) {
                        System.out.print(i + " ");
                        break;
                    }
                    if (c[i] == 0) {
                        n++;
                        continue;
                    }

                }
                break;
            case 6:
                System.out.println("occurance Sorting");
                for (int i = 1; i < 1000; i++) {
                    for (int og = c[i]; og > 0; k = og--)
                        if (c[i] != 0) {
                            System.out.print(i + " ");
                        }
                }
                break;

            default:
                System.out.println("Enter Valid Choice");
        }

        s.close();
    }
}
