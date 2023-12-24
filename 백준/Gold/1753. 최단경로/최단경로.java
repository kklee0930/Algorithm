import java.io.*;
import java.util.*;

class Node {
    int endNode;
    int weight;

    Node(int endNode, int weight) {
        this.endNode = endNode;
        this.weight = weight;
    }
}

public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparing(node -> node.weight));
    static int INF = 3000000;
    static int lastVisited = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visited = new boolean[node+1]; // 방문여부 배열
        graph = new ArrayList<>(); // 그래프간 경로 및 가중치 배열
        dist = new int[node+1]; // 노드별 최단거리 배열

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        for(int i = 0; i < node+1; i++) {
            graph.add(new ArrayList<>());
        }

        int startNode = Integer.parseInt(br.readLine());

        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 경로 시작 노드
            int v = Integer.parseInt(st.nextToken()); // 경로 끝 노드
            int weight = Integer.parseInt(st.nextToken()); // 노드간 거리
            graph.get(u).add(new Node(v, weight));
        }

        br.close();

        dijkstra(startNode);

        for(int i = 1; i <= node; i++) {
            int res = dist[i];
            if(res == INF) {
                sb.append("INF").append("\n");
            }
            else {
                sb.append(dist[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dijkstra(int startNode) {

        heap.add(new Node(startNode, 0));
        dist[startNode] = 0;

        while(!heap.isEmpty()) {

            Node currentNodeData = heap.poll();
            int currentNode = currentNodeData.endNode;
            int currentDist = currentNodeData.weight;

            visited[currentNode] = true;
            lastVisited = currentNode; // 경로가 없는 노드를 pop했을

            // 현재 노드 데이터의 최단거리가 더 클 경우 아래 과정 무의미
            if(currentDist > dist[currentNode]) {
                continue;
            }

            for(Node nodeData : graph.get(currentNode)) {

                int adjacentNode = nodeData.endNode; // 인접노드
                int adjacentWeight = nodeData.weight; // 인접노드의 가중치

                // 인접 노드가 방문하지 않았고 현재노드 거리 + 다음노드 거리 < 다음노드 최단거리이면 최단거리 변경 처리
                if(!visited[adjacentNode] && dist[adjacentNode] > dist[currentNode] + adjacentWeight) {

                    dist[adjacentNode] = dist[currentNode] + adjacentWeight;
                    heap.add(new Node(adjacentNode, dist[adjacentNode]));
                }
            }
        }
    }
}
