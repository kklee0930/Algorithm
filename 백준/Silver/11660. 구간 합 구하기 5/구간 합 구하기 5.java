import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1]; // 표 저장
        int[][] dp = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < N+1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i][j-1] + graph[i][j]; //dp[i][j] = 이전 dp[i][j]값 + 현재 graph[i][j]값
            }
        }

        for(int i = 0; i < M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2+1; j++) {
                sum += dp[j][y2] - dp[j][y1-1];
            }
            bw.write(sum + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}