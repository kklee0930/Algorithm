import java.util.*;
import java.io.*;

public class Main {
    static Integer[][] dp;
    static int[][] array;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][N];
        array = new int[N][N]; // 입력받은 값을 저장할 array

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // dp의 마지막줄에 array의 마지막줄 값들을 추가해준다.
        for(int i = 0; i < N; i++){
            dp[N-1][i] = array[N-1][i];
        }
        System.out.println(search(0, 0));

    }
    static int search(int depth, int idx){
        if(depth == N-1){ // 가장 아래까지 도달한 경우에 미리 저장한 dp의 값을 return한다.
            return dp[depth][idx];
        }
        if(dp[depth][idx] == null){ // 아직 입력이 되지 않은 경우에는 아래층으로 재귀하며 탐색한다.
            dp[depth][idx] = Math.max(search(depth+1, idx), search(depth+1, idx+1)) + array[depth][idx];
        }
        return dp[depth][idx];
    }
}