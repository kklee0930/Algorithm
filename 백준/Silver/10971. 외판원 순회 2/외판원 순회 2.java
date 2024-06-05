import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;
    static int[][] graph;
    static int N;
    static int cost;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];
        cost = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0); // 시작지점, 현재 이동중인 지점, 현재 지점까지의 누적거리, 방문횟수
        }
        bw.write(cost + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int current, int sum, int depth) {
        // 방문 depth가 N에 도달한 경우 시작지점과 현재지점의 연결상태를 확인하여 최종 거리값 계산
        if(depth == N - 1) {
            if(graph[current][start] != 0) {
                sum += graph[current][start];
                cost = Math.min(sum, cost);
            }
            return;
        }
        // 백트래킹 처리
        for(int i = 0; i < N; i++) {
            // 방문하지 않았고 해당 인덱스가 연결되어 있는 경우에만 진행
            if(!visited[i] && graph[current][i] > 0) {
                visited[i] = true;
                dfs(start, i, sum + graph[current][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}