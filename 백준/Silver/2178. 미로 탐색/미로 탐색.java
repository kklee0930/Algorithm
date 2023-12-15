import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();

            // 미로의 값 저장
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        br.close();

        visited[0][0] = true;
        bfs(0, 0);

        bw.write(String.valueOf(map[N-1][M-1]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {

        // 큐에 x, y 좌표쌍 저장
        queue.addLast(new int[] {x, y});

        while(!queue.isEmpty()) {

            // 큐에서 가장 아래에 있는 좌표값 제거하고 이동칸수++
            int[] coordSet = queue.removeFirst();
            int xValue = coordSet[0];
            int yValue = coordSet[1];

            for(int i = 0; i < 4; i++) {
                int nx = xValue + dx[i];
                int ny = yValue + dy[i];

                // 범위를 벗어나지 않고 해당 좌표값이 1이고 방문이력이 없다면
                if(nx > -1 && nx < N && ny > -1 && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.addLast(new int[] {nx, ny});
                    map[nx][ny] = map[xValue][yValue] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }
}