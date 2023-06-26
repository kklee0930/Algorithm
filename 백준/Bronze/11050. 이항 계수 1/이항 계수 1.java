import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        System.out.println(factorial(N) / (factorial(N-K) * factorial(K)));
    }

    public static int factorial(int n){
        int result = 1;
        for(int i = n; i > 0; i--){
            result *= i;
        }
        return result;
    }
}