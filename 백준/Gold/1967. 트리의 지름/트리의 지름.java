import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static int maxWeight;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무방향 그래프이기 때문에 부모-자식, 자식-부모 모두 연결
            graph[parentNode].add(new Node(childNode, weight));
            graph[childNode].add(new Node(parentNode, weight));
        }
        br.close();

        maxWeight = 0;
        for(int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(maxWeight);
    }

    private static void dfs(int currentNum, int currentWeight) {
        for(Node node : graph[currentNum]) {
            // 아직 연결된 해당 노드를 방문하지 않았다면
            if(!visited[node.nodeNum]) {
                visited[node.nodeNum] = true;
                dfs(node.nodeNum, currentWeight + node.weight);
            }
        }
        maxWeight = Math.max(maxWeight, currentWeight);
    }

    static class Node {
        int nodeNum;
        int weight;

        Node(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }
    }
}