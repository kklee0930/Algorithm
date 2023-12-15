import java.io.*;
import java.util.*;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 갯수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());

            // 필요한 지렁이 마리 수
            int cnt = 0;

            // 배추밭 가로길이
            M = Integer.parseInt(st.nextToken());
            // 배추밭 세로길이
            N = Integer.parseInt(st.nextToken());
            // 배추 위치 갯수
            int K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new boolean[M][N];

            // 배추들의 위치
            for(int j = 0; j < K; j++) {

                st = new StringTokenizer(br.readLine());

                // 배추 x, y 좌표값
                int xCoord = Integer.parseInt(st.nextToken());
                int yCoord = Integer.parseInt(st.nextToken());

                map[xCoord][yCoord] = 1;
            }

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {

                    // 방문하지 않았고 배추가 심어져있을 경우에만 dfs
                    if(!visited[x][y] && map[x][y] == 1) {
                        cnt++;
                        dfs(x, y);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(int x, int y) {

        // 지렁이 마리 수++ 하고 방문처리
        visited[x][y] = true;

        // 인접한 배추 확인
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 해당 좌표가 범위를 벗어나지 않고 방문하지 않았고 배추가 존재하는 경우일때 재귀
            if(nx > -1 && nx < M && ny > -1 && ny < N
                    && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}