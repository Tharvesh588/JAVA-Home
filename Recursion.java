public class Recursion {
    public static void main(String[] args) {
        printNo(10);   
    }

    public static void printNo(int n){
        if(n==1){
            System.out.println(n);
        }
        else{
            System.out.println(n);
            printNo(n-1);
        }
    }
}
