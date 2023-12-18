import java.io.*;
import java.util.*;

public class Main {

    private static int x;
    private static int y;
    private static int[][] map;
    private static int M;
    private static int N;
    private static int totalCnt = 0;
    private static int tomatoCnt;
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); // 세로 칸의 수

        map = new int[N][M]; // 토마토가 들어있는 상자

        int oneCnt = 0; // 익은 토마토 갯수
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;

                if(number == 1) {
                    queue.addLast(new int[]{i, j});
                    oneCnt++;
                    totalCnt++;
                }
                else if(number == 0) {
                    totalCnt++;
                }
            }
        }

        br.close();

        // 토마토가 다 익어있다면
        if(oneCnt == totalCnt) {
            bw.write(String.valueOf(0));
        }
        else {
            bfs();

            // 토마토가 다 익지 않았다면
            if(tomatoCnt != totalCnt) {
                bw.write(String.valueOf(-1));
            }
            else {
                // 1일부터 시작하기 때문에 -1
                bw.write(String.valueOf(map[x][y] - 1));
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs() {

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        tomatoCnt = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            tomatoCnt++;

            x = current[0];
            y = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        queue.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}