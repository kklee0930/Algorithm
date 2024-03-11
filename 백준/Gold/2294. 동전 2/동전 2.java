import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 가짓 수
        int k = Integer.parseInt(st.nextToken()); // 동전 합의 가치

        int[] arr = new int[n];
        for(int i  = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        br.close();
        bw.write(String.valueOf(dp[k] == 100001 ? -1 : dp[k]));
        bw.flush();
        bw.close();
    }
}