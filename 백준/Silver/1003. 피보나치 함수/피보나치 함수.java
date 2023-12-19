import java.io.*;

public class Main {

    private static final Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // N이 0일 때 0갯수와 1갯수
        dp[0][0] = 1;
        dp[0][1] = 0;
        // N이 1일 때 0갯수와 1갯수
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static Integer[] fibonacci(int n) {
        // 존재하지 않는다면 memoization 처리
        if(dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        // 존재하면 return
        return dp[n];
    }
}