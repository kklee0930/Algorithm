import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int INF = 200000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        // 노드간 거리 저장하는 배열
        dist = new int[node+1];
        visited = new boolean[node+1];

        for(int i = 0; i < node+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {

            // 정점(a, b), 정점 간의 거리 c
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 목적지와 가중치 그래프의 startNode인덱스에 저장
            graph.get(startNode).add(new int[]{endNode, weight});
            // 양방향이기 때문에 역으로도 저장
            graph.get(endNode).add(new int[]{startNode, weight});
        }

        // 반드시 거쳐야 하는 두 정점(v1, v2)
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        br.close();

        // 경로가 1 -> v1 -> v2 -> N
        int answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, node);

        // 경로가 1 -> v2 -> v1 -> N
        int answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, node);

        int answer = (answer1 >= INF && answer2 >= INF) ? -1 :
                Math.min(answer1, answer2);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        // 노드간 거리값 INF로 초기화
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        // 최소힙이 다익스트라 알고리즘에서의 Q역할을 수행
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        heap.add(new int[]{start, 0});
        dist[start] = 0;

        while(!heap.isEmpty()) {
            int[] currentNodeData = heap.poll();
            int currentNode = currentNodeData[0];
            int currentDist = currentNodeData[1]; // 현재 노드의 최단경로 거리값

            // 방문하지 않았다면 방문처리(알고리즘상 S 집합에 저장)
            if(!visited[currentNode]) {
                visited[currentNode] = true;
            }

            // 인접노드 탐색
            for(int[] nodeData : graph.get(currentNode)) {
                int adjacentNode = nodeData[0]; // 다음 이동할 노드
                int weight = nodeData[1]; // 다음 이동할 노드까지의 거리(가중치)

                // 다음 이동할 노드를 방문하지 않았고, 현재 거리값 + 다음노드까지의 거리 < 이동할 노드의 최단경로 거리값일 경우
                if(!visited[adjacentNode] && currentDist + weight < dist[adjacentNode]) {
                    // 방문한 인접노드의 최단경로값 수정
                    dist[adjacentNode] = currentDist + weight;
                    // 우선순위큐에 다음노드 추가
                    heap.add(new int[]{adjacentNode, dist[adjacentNode]});
                }
            }
        }

        return dist[end];
    }
}
