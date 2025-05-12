import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int duplicate = num;
        int sum = 0;
        int len = String.valueOf(num).length();

        while (duplicate > 0) {
            int _num = duplicate % 10;
            sum += Math.pow(_num, len);
            duplicate /= 10;
        }
        System.out.println((num == sum)?"Yes":"No");
        s.close();
    }
}
