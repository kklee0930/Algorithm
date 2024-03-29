import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(N, M, 0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int n: arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = i+1;
            dfs(N, M, depth+1);
        }
    }
}