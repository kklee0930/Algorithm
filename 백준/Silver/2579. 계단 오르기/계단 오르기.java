import java.util.*;

public class Main {
    static Integer[] dp;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new Integer[N+1];
        arr = new int[N+1];

        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N >= 2){
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(recursion(N));
    }

    static int recursion(int idx){
        if(dp[idx] == null){
            dp[idx] = Math.max(recursion(idx-2), recursion(idx-3) + arr[idx-1]) + arr[idx];
        }
        return dp[idx];
    }
}