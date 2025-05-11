import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.print("Enter a second number: ");
        int secondNumber = input.nextInt();
        System.out.print("Enter a third number: ");
        int thirdNumber = input.nextInt();
        System.out.println("Sum: " + sum(number, secondNumber, thirdNumber));
        System.out.println("Average: " + average(number, secondNumber, thirdNumber));
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static double average(int a, int b, int c) {
        return (double) sum(a, b, c) / 3;
    }
}