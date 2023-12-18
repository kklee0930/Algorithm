import java.io.*;
import java.util.*;

public class Main {

    private static int[][][]map;
    private static final ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static int M;
    private static int N;
    private static int H;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 상자 가로 칸의 수
        N = Integer.parseInt(st.nextToken()); // 상자 세로 칸의 수
        H = Integer.parseInt(st.nextToken()); // 쌓아올린 상자 수(높이)

        map = new int[H+1][N+1][M+1]; // z, x, y
        boolean zeroCnt = false; // 안익은 토마토 갯수

        for(int i = 1; i <= H; i++) { // z
            for(int j = 1; j <= N; j++) { // x
                st = new StringTokenizer(br.readLine());

                for(int k = 1; k <= M; k++) { // y
                    int number = Integer.parseInt(st.nextToken());
                    map[i][j][k] = number;

                    // 토마토가 존재하는 경우에 queue에 추가 / 전체 토마토칸 갯수++
                    if(number == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                    // 빈 칸일 경우에 전체 토마토칸 갯수++
                    else if(number == 0) {
                        zeroCnt = true;
                    }
                }
            }
        }

        br.close();

        // 안익은 토마토가 없으면 모두 익은 상태
        if(!zeroCnt) {
            bw.write(String.valueOf(0));
        }
        else {
            bw.write(String.valueOf(bfs()));
        }

        bw.flush();
        bw.close();
    }

    private static int bfs() {

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        int daysCnt = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            int[] currentCoord = queue.removeFirst();

            int height = currentCoord[0];
            int row = currentCoord[1];
            int col = currentCoord[2];

            daysCnt = Math.max(daysCnt, map[height][row][col]);

            for(int i = 0; i < 6; i++) {
                int nz = height + dz[i];
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(nx > 0 && ny > 0 && nz > 0 && nx <= N && ny <= M && nz <= H) {
                    if(map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = map[height][row][col] + 1;
                        queue.addLast(new int[]{nz, nx, ny});
                    }
                }
            }
        }

        for(int i = 1; i <= H; i++) { // z
            for(int j = 1; j <= N; j++) { // x
                for(int k = 1; k <= M; k++) { // y

                    // 토마토가 모두 익지 못하는 상황
                    if(map[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        // 시작점에서 1일부터 시작하기 때문에 -1
        return daysCnt-1;
    }
}