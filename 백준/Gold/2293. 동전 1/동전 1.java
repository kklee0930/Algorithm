import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 가짓 수
        int k = Integer.parseInt(st.nextToken()); // 동전 합의 가치

        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for(int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for(int j = arr[i]; j < k + 1; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        br.close();
        bw.write(dp[k]+"");
        bw.flush();
        bw.close();
    }
}