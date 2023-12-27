import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int cnt;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int vertexCnt = Integer.parseInt(input[0]);
        int edgeCnt = Integer.parseInt(input[1]);

        // 간선 저장용 배열
        graph = new ArrayList<>();
        for(int i = 0; i < vertexCnt + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 여부 확인용 배열
        visited = new boolean[vertexCnt + 1];

        for(int i = 0; i < edgeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 방향이 없는 그래프, 양방향 그래프
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        br.close();
        cnt = 0;

        for(int i = 1; i < vertexCnt + 1; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int start) {
        // 간선 X존재시 종료
        if(graph.get(start).isEmpty()) {
            return;
        }
        visited[start] = true;
        // 인접노드 탐색
        for(int adjacent : graph.get(start)) {
            if(!visited[adjacent]) {
                dfs(adjacent);
            }
        }
    }
}
