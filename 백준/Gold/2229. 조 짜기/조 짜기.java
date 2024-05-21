import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        dp[0] = 0;
        dp[1] = 0;
        arr[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int max = 0;
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j = i - 1; j > 0; j--) {
                max = Math.max(max, Math.abs(arr[i] - arr[j]) + dp[j - 1]);
            }
            dp[i] = max;
            result = dp[i];
        }

        System.out.println(result);
    }
}