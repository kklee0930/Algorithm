import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    public static int[] visited;
    static int order;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        // 방문 순서를 체크하기 위한 배열
        visited = new int[N+1];

        for(int i = 0; i < N+1; i++) {

            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            // 간선 u, 간선 v
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        br.close();

        // graph 배열 원소들 오름차순 정렬
        for(ArrayList<Integer> array : graph) {

            Collections.sort(array);
        }

        order = 1;
        bfs(R);

        for(int i = 1; i < visited.length; i++) {
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int start) {

        visited[start] = order; // 시작정점을 방문처리
        order++;

        deque.addLast(start); // queue의 맨 뒤에 시작 정점을 추가
        while(!deque.isEmpty()) {

            int u = deque.removeFirst();

            for(int adjacentNode : graph.get(u)) { // 제거한 인접 정접의 집합(오름차순으로 방문)

                if(visited[adjacentNode] == 0) {
                    visited[adjacentNode] = order; // 인접 정점 방문처리
                    order++;
                    deque.addLast(adjacentNode); // 큐의 맨 뒤에 정점 추가
                }
            }
        }
    }
}