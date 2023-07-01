import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb;
    static int prevNum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.close();

        arr = new int[M];
        sb = new StringBuilder();
        dfs(0, N, M, 0);

        System.out.println(sb);
    }

    public static void dfs(int start, int N, int M, int depth){
        if(depth == M){
            for(int n: arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = start; i < N; i++){
            arr[depth] = i+1;
            prevNum = i+1;
            dfs(i, N, M, depth+1);
        }
    }
}