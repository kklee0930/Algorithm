import java.util.*;
import java.io.*;

class Main {
    
    static List<Node>[] graph;
    static int[] dp;
    static boolean[] visited;
    static int n;
    static int d;

    static class Node implements Comparable<Node> {
        int nodeIndex;
        int time;

        public Node(int nodeIndex, int time) {
            this.nodeIndex = nodeIndex;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
        
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;

            graph = new ArrayList[n]; // 컴퓨터간 거리
            for(int j = 0; j < n; j++) {
                graph[j] = new ArrayList<>();
            }
            
            dp = new int[n]; // 해당 컴퓨터까지의 최단거리(초)
            visited = new boolean[n]; // 컴퓨터 방문여부

            for(int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());

                graph[b].add(new Node(a, s)); // 컴퓨터간 의존관계 및 감염 소요시간
            }
            Arrays.fill(dp, Integer.MAX_VALUE); // 노드별 최단거리 MAX_VALUE로 설정
            dp[c] = 0;
            
            int[] result = dijkstra(c);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(int start) {

        int cnt = 0;
        int totalTime = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIdx = current.nodeIndex;
            int currentTime = current.time;

            if(visited[currentIdx]) {
               continue;
            }
            
            visited[currentIdx] = true; // 감염처리
            totalTime = currentTime;
            cnt++;
    
            for(int i = 0; i < graph[currentIdx].size(); i++) {
                Node nextNode = graph[currentIdx].get(i);
                int nextIndex = nextNode.nodeIndex;
                int nextDistance = nextNode.time;

                // 노드 별 최단거리 갱신
                if(dp[currentIdx] + nextDistance < dp[nextIndex]) {
                    dp[nextIndex] = dp[currentIdx] + nextDistance;
                    pq.offer(new Node(nextIndex, dp[nextIndex]));
                }
            }
        }
        return new int[]{cnt, totalTime};
    }
}