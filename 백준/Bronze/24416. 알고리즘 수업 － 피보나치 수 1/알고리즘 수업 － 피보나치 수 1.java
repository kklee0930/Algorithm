import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.close();

        int cnt = 0;
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for(int i = 2; i < n; i++){
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
            cnt++;
        }
        System.out.println(recursion(n)+" "+cnt);

    }

    public static int recursion(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else {
            return recursion(n-2) + recursion(n-1);
        }
    }
}