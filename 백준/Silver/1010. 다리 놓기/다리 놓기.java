import java.io.*;
import java.util.*;

public class Main {
    public static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
            sb.append(combination(M, N)).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    public static int combination(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        if(n == r || r == 0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
}