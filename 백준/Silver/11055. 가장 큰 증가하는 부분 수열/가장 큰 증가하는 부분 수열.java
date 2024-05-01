import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];

        for(int i = 1; i <= N; i++) {
            int currentNum = arr[i];
            dp[i] = arr[i];
            // 현재 누적합(dp[i])과 이전 누적합(dp[j]) + 현재 값(currentNum) 비교
            for(int j = 1; j < i; j++) {
                // 현재값이 이전값보다 클 경우에만(오름차순일 경우에만)
                if(currentNum > arr[j]) {
                    dp[i] = Math.max(dp[j] + currentNum, dp[i]);
                }
            }
        }
        bw.write(Arrays.stream(dp).max().getAsInt() + "");
        bw.flush();
        bw.close();
    }
}