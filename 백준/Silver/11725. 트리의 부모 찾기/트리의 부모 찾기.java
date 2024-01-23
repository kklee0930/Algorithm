import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] parentNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1]; // 연결된 노드 데이터 저장
        visited = new boolean[N+1]; // 노드 방문 여부 저장
        parentNode = new int[N+1]; // 노드의 부모노드 저장

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // i노드와 연결되는 노드 저장
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        br.close();

        for(int i = 2; i <= N; i++) {
            bw.write(parentNode[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int idx) {
        visited[idx] = true;

        for(int node : graph[idx]) {
            if(!visited[node]) {
                parentNode[node] = idx;
                dfs(node);
            }
        }
    }
}