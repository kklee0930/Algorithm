import java.io.*;
import java.util.*;

public class Main {

    // 방문여부 확인용 배열
    static boolean[] bfsVisited;
    static boolean[] dfsVisited;

    // 정점의 순서
    static StringBuilder bfsStringBuilder = new StringBuilder();
    static StringBuilder dfsStringBuilder = new StringBuilder();

    // 연결된 정점을 담기위한 graph 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // bfs를 위한 queue
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int M = Integer.parseInt(st.nextToken()); // 간선의 갯수
        int V = Integer.parseInt(st.nextToken()); // 시작할 정점

        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 주어진 간선의 갯수 값 M 만큼 반복
        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 양방향
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 간선 오름차순 정렬
        for(ArrayList<Integer> array : graph) {

            Collections.sort(array);
        }

        dfsVisited = new boolean[N+1];
        dfs(V);

        bfsVisited = new boolean[N+1];
        bfs(V);

        bw.write(dfsStringBuilder + "\n");
        bw.write(bfsStringBuilder.toString());

        bw.flush();
        bw.close();
    }

    private static void dfs(int start) {

        // 시작점 방문 처리
        dfsVisited[start] = true;
        dfsStringBuilder.append(start).append(" ");

        // 정점과 인점한 정점 순환
        for(int adjacentNode : graph.get(start)) {
            // 방문하지 않았다면 재귀
            if(!dfsVisited[adjacentNode]) {
                dfs(adjacentNode);
            }
        }
    }

    private static void bfs(int start) {

        // 시작점 방문 처리
        bfsVisited[start] = true;
        bfsStringBuilder.append(start).append(" ");

        // 시작 정점 값 queue에 저장
        queue.addLast(start);

        while(!queue.isEmpty()) {
            int currentNode = queue.removeFirst();

            for(int adjacentNode : graph.get(currentNode)) {

                // 아직 방문하지 않은 정점이라면
                if(!bfsVisited[adjacentNode]) {
                    // 방문 처리
                    bfsVisited[adjacentNode] = true;
                    bfsStringBuilder.append(adjacentNode).append(" ");
                    // queue에 추가해준다.
                    queue.addLast(adjacentNode);
                }
            }
        }
    }
}