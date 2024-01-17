import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int[] arr = new int[N]; // 주어진 값을 저장할 배열
        int[] dp = new int[N]; // memoization

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            dp[i] = 1;
            for(int j = 0; j < i; j++) {

                // j번째 arr값 < i번째 arr값 & i번째 dp값 < j번째 dp값+1
                // 현재 dp값에 1더해주기
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxVal = 0;
        for(int i = 0; i < N; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        bw.close();
    }
}