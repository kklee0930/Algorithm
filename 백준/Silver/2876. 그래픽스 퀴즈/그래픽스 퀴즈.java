import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][5];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            dp[i][a]++;
            dp[i][b]++;
        }
        br.close();

        int[] answer = new int[5];
        // 1부터 5까지 loop돌며 연속되는 값 계산
        for(int i = 0; i < 5; i++) {
            // ans: 누적 최대값
            int sum = 0, ans = 0;

            for(int j = 0; j < N; j++) {
                int currentVal = dp[j][i] > 0 ? 1 : 0;

                // dp[j][i]의 값이 0이면 연속이 끊어지기 때문에 sum=0 처리
                if(currentVal == 0) {
                    sum = 0;
                } else {
                    sum += currentVal;
                }
                ans = Math.max(ans, sum);
            }
            answer[i] = ans;
        }

        int grade = 0;
        int maxCnt = 0;
        for(int i = 0; i < 5; i++) {
            if(answer[i] > maxCnt) {
                maxCnt = answer[i];
                grade = i + 1;
            }
        }

        bw.write(maxCnt + " " + grade);
        bw.flush();
        bw.close();
    }
}
