import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        for(int i = 3; i < dp.length; i++){
            dp[i] = -1;
        }
        System.out.println(fibonacci(N));

    }
    static int fibonacci(int goal){
        if(dp[goal] == -1){
            dp[goal] = fibonacci(goal-1) + fibonacci(goal-2);
        }
        return dp[goal] % 15746;
    }
}