import java.io.*;
import java.util.*;

public class Main {

    static int WHITE = 1;
    static int BLACK = -1;
    static int vertexCnt;
    static int[] visitedColor;
    static boolean isBipartite;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트케이스 갯수
        int K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            // 정점 갯수, 간선 갯수, 노드의 방문 여부 및 색깔(bipartite여부 확인용)
            vertexCnt = Integer.parseInt(st.nextToken());
            int edgeCnt = Integer.parseInt(st.nextToken());
            visitedColor = new int[vertexCnt + 1];

            // 간선(u, v) 정보 담는 배열
            graph = new ArrayList<>();
            for(int v = 0; v < vertexCnt + 1; v++) {
                graph.add(new ArrayList<>());
            }

            for(int j = 0; j < edgeCnt; j++) {
                st = new StringTokenizer(br.readLine());
                // 정점 u, 정점 v
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                // 양방향 그래프
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 이분그래프 여부
            isBipartite = true;
            for(int k = 1; k < vertexCnt + 1; k++) {

                // 방문하지 않은 정점에 한해서만 수행
                if(visitedColor[k] == 0) {
                    bfs(k, WHITE);
                }

                if(!isBipartite) {
                    break;
                }
            }
            bw.write(isBipartite ? "YES" + "\n" : "NO" + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int startNum, int color) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        // 초기 노드값 간선 색깔 지정
        visitedColor[startNum] = color;
        queue.add(startNum);

        while(!queue.isEmpty() && isBipartite) {
            int current = queue.poll();

            for(int adjacent : graph.get(current)) {
                // 아직 방문하지 않은 인접노드의 경우엔 색깔 지정해주고 큐에 추가
                if(visitedColor[adjacent] == 0) {
                    queue.add(adjacent);
                    visitedColor[adjacent] = -1 * visitedColor[current];
                }
                // 이미 방문한 경우엔 이분그래프인지 확인하고 아니면 종료
                else if(visitedColor[adjacent] + visitedColor[current] != 0) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
