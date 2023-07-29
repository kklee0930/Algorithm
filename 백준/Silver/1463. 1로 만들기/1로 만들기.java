import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(recursion(N));
    }

    static int recursion(int N){
        if(dp[N] == null){
            if(N % 6 == 0){
                dp[N] = Math.min(Math.min(recursion(N/2), recursion(N/3)), recursion(N-1)) + 1;
            }
            else if(N % 3 == 0){
                dp[N] = Math.min(recursion(N/3), recursion(N-1)) + 1;
            }
            else if(N % 2 == 0){
                dp[N] = Math.min(recursion(N/2), recursion(N-1)) + 1;
            }
            else {
                dp[N] = recursion(N-1) + 1;
            }
        }
        return dp[N];
    }

}