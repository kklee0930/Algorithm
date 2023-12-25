import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i+1][j+1] = row.charAt(j);
            }
        }
        br.close();
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    static int bfs() {

        // 델타탐색
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // visited[][][0] -> 벽을 한번도 부수지 않고 방문하는 경우
        // visited[][][1] -> 벽을 부수고 방문하는 경우
        boolean[][][] visited = new boolean[n+1][m+1][2];

        // 시작점
        int x = 1;
        int y = 1;
        ArrayDeque<Coord> queue = new ArrayDeque<>();
        queue.add(new Coord(x, y, 1, true)); // x값, y값, 이동횟수, 벽 파괴가능 여부

        while(!queue.isEmpty()) {
           Coord currentCoord = queue.poll();
            int currentX = currentCoord.x;
            int currentY = currentCoord.y;

            if(currentX == n && currentY == m) {
                return currentCoord.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                // 범위체크
                if(nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                // 다음 좌표의 이동 횟수
                int nextCnt = currentCoord.cnt + 1;

                // 벽이 아닐 경우
                if(map[nx][ny] == '0') {

                    // 벽을 부순 이력이 없고 방문 이력이 없을 때
                    if(currentCoord.breakable && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.add(new Coord(nx, ny, nextCnt, true));
                    }
                    // 벽을 부순 이력이 있고 방문 이력이 없을 때
                    else if(!currentCoord.breakable && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Coord(nx, ny, nextCnt, false));
                    }
                }

                // 벽일 경우
                if(map[nx][ny] == '1') {

                    // 벽을 부순 이력이 없고 방문 이력이 없을 때
                    if(currentCoord.breakable && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Coord(nx, ny, nextCnt, false));
                    }
                }
            }
        }
        return -1;
    }
    static class Coord {
        int x;
        int y;
        int cnt;
        boolean breakable;

        Coord(int x, int y, int cnt, boolean breakable) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakable = breakable;
        }
    }
}
