import java.io.*;
import java.util.*;

public class Main {

    static int[] visited;
    static int order;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new int[N+1]; // 방문 여부 체크 위한 배열

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선의 갯수만큼 iteration
        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작점
            int v = Integer.parseInt(st.nextToken()); // 끝점

            // 양방향이기 때문에 두 방향 모두 추가
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 정점 번호 방문을 위한 내림차순 정렬
        for(ArrayList<Integer> array : graph) {
            array.sort(Collections.reverseOrder());
        }

        order = 1;
        bfs(R);

        for(int i = 1; i < visited.length; i++) {

            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {

        visited[start] = order; // 시작 지점의 순서를 1로 지정
        order++;

        queue.addLast(start);

        while(!queue.isEmpty()) {
            int adjacentNode = queue.removeFirst(); // 큐의 가장 인접한 노드
            // 해당 노드와 연결된 노드를 순회
            for(int node : graph.get(adjacentNode)) {

                if(visited[node] == 0) { // 정점과 인접한 노드가 방문한 적이 없으면
                    visited[node] = order; // 방문처리
                    order++;
                    queue.addLast(node); // queue에 마지막에 추가
                }
            }
        }
    }
}