import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        sc.close();

        visited = new boolean[N];
        arr = new int[M];

        sb = new StringBuilder();
        dfs(N, M, 0);

        System.out.println(sb);

    }

    public static void dfs(int N, int M, int depth){
        if(M == depth){
            for(int num: arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                if(depth > 0 && arr[depth-1] >= i+1){
                    continue;
                }
                visited[i] = true;
                arr[depth] = i+1;
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}