import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            graph[i] = charArray;
        }
        br.close();

        // 적녹색약이 아닌 사람이 보는 구역 수
        int areaCnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, graph[i][j]);
                    areaCnt++;
                }
                // 적녹색약을 bfs를 위해 R을 모두 G로 변경처리
                if(graph[i][j] == 'R') {
                    graph[i][j] = 'G';
                }
            }
        }

        visited = new boolean[N][N];
        // 적녹색약인 사람이 보는 구역 수
        int colorBlindCnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, graph[i][j]);
                    colorBlindCnt++;
                }
            }
        }
        bw.write(areaCnt + " " + colorBlindCnt);
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] currentData = queue.poll();

            int currentX = currentData[0];
            int currentY = currentData[1];

            for(int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                // 범위를 벗어난 경우에는 continue
                if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) {
                    continue;
                }
                // 색깔이 같고 방문하지 않은 경우에만 queue에 추가
                if(color == graph[nx][ny] && !visited[nx][ny]) {
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}