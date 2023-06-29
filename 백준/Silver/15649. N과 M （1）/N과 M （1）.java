import java.util.*;

public class Main {
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt(); // 1부터 N까지 숫자가 주어졌을 때 중복없이 M개 뽑기
        sb = new StringBuilder();

        visited = new boolean[N]; // 해당 값을 방문 했는지 체크위한 array(중복을 막기 위함)
        arr = new int[M]; // 현재 값을 저장하기 위한 array

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

        for(int i = 0; i < N; i++){ // N = 1부터 N까지의 자연수
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1; // depth = 자릿수
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }
    }
}