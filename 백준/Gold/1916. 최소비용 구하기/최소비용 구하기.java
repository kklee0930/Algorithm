import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int endNode;
    int distance;

    Node(int endNode, int distance) {
        this.endNode = endNode;
        this.distance = distance;
    }

    // 우선순위 큐 정렬
    @Override
    public int compareTo(Node o) {
        return distance - o.distance;
    }
}

public class Main {

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        visited = new boolean[city+1]; // 방문이력확인
        distance = new int[city+1]; // 각 노드의 최단거리

        for(int i = 0; i < city+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            // 그래프에 목적지 정보 저장
            graph.get(start).add(new Node(end, dist));
        }

        st = new StringTokenizer(br.readLine());
        // 출발지점과 목적지
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        br.close();
        bw.write(String.valueOf(dijkstra(startCity, endCity)));
        bw.flush();
        bw.close();
    }

    static int dijkstra(int start, int end) {

        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        // 노드의 최단거리를 기준으로 오름차순 정렬되는 우선순위큐
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(start, 0));
        distance[start] = 0;

        while(!heap.isEmpty()) {
            // 현재 노드 정보
            Node node = heap.poll();
            int currentNode = node.endNode;
            int currentDist = node.distance;

            // 현재노드 방문하지 않았다면 방문 처리(S집합에 추가)
            if(!visited[currentNode]) {
                visited[currentNode] = true;
            }

            // 힙에 같은 노드에 대한 거리가 여러개 들어갈 수 있으므로
            if(currentDist > distance[currentNode]) {
                continue;
            }

            // 현재 노드와 인접한 노드 iteration
            for(Node adjacentNode : graph.get(currentNode)) {
                int nextNode = adjacentNode.endNode;
                int weight = adjacentNode.distance;

                // 인접노드 방문이력 없고, 지금노드 + 거리 < 해당노드 최단거리면 값 변경
                if(!visited[nextNode] && currentDist + weight < distance[nextNode]) {
                    distance[nextNode] = currentDist + weight;
                    heap.add(new Node(nextNode, distance[nextNode]));
                }
            }
        }

        return distance[end];
    }
}
