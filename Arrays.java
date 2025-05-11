import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] Arr = new int[n];

        // Create an array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0 ;i<n; i++){
            Arr[i] = sc.nextInt();
        }

        //sum of the array
        int sum = 0;
        for(int i= 0; i<Arr.length; i++){
            sum = sum + Arr[i];
        }
        System.out.println("Sum of the array is: " + sum);
        System.out.println("Average of the array is: " + ((float)sum/n) + " ~ " + (sum/n));

    }

}
