public class Palindrome {
    public static void main(String[] args) {
        int data, ori;
        data = ori = 121;

        int temp = 0;

        while (data > 0) {
            int n = data % 10;          
            temp = (temp * 10) + n;     
            data /= 10;             
        }

        if (ori == temp) {
            System.out.println(ori + " is a palindrome.");
        } else {
            System.out.println(ori + " is not a palindrome.");
        }
    }
}
