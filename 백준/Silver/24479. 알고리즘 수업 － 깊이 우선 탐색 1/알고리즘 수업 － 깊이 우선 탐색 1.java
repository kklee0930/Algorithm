import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int order;

    public static void dfs(int start) {

        // 노드의 방문 순서를 저장
        visited[start] = order;
        order++;

        for(int i = 0; i < graph.get(start).size(); i++) {

            int adjacentNode = graph.get(start).get(i);

            // 인접 노드가 미방문 상태라면 방문
            if(visited[adjacentNode] == 0) {

                dfs(adjacentNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int R = Integer.parseInt(st.nextToken()); // 시작점

        visited = new int[N+1];

        // 양방향 간선 데이터 저장을 위한 graph
        for(int i = 0; i < N+1; i++) {

            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선이기 때문에 u, v방향 데이터 모두 저장
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        br.close();

        // 오름차순 정렬
        for (ArrayList<Integer> data : graph) {

            Collections.sort(data);
        }

        // 노드의 방문순서
        order = 1;
        dfs(R);

        for(int i = 1; i < visited.length; i++) {

            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}