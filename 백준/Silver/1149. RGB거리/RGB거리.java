import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dp = new int[N][3];
        cost = new int[N][3]; // 각 줄 별로 주어진 칠하는 비용(빨강, 초록, 파랑 세가지)

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            // 빨강 = 0, 초록 = 1, 파랑 = 2
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp[0]의 값들은 처음으로 주어지는 값들과 같음
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 끝부터 시작
        System.out.println(Math.min(recursion(N-1, 0), Math.min(recursion(N-1, 1), recursion(N-1, 2))));
    }

    static int recursion(int N, int color){
        // 탐색하지 않은 배열일 경우에만 실행
        if(dp[N][color] == 0){
            if(color == 0){ // 빨강색이면 min(나머지 두 색깔) + 현재 cost
                dp[N][0] = Math.min(recursion(N-1, 1), recursion(N-1, 2)) + cost[N][0];
            }

            else if(color == 1){ // 초록색이면 min(나머지 두 색깔) + 현재 cost
                dp[N][1] = Math.min(recursion(N-1, 0), recursion(N-1, 2)) + cost[N][1];
            }

            else { // 파란색이면 min(나머지 두 색깔) + 현재 cost
                dp[N][2] = Math.min(recursion(N-1, 0), recursion(N-1, 1)) + cost[N][2];
            }
        }

        return dp[N][color];
    }
}