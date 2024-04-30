import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int w;
    static int h;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            w = Integer.parseInt(st.nextToken()); // 지도의 너비
            h = Integer.parseInt(st.nextToken()); // 지도의 높이
            
            if(w == 0 && h == 0) {
                break;
            }
            
            visited = new boolean[h][w]; // 방문여부 처리
            map = new int[h][w]; // 섬의 지도
            int cnt = 0; // 섬의 갯수
            
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int r, int c) {
        
        for(int i = 0; i < 8; i++) {
            int ny = dy[i] + r;
            int nx = dx[i] + c;

            // 범위를 벗어나면 continue
            if(nx < 0 || ny < 0 || ny >= h || nx >= w) {
                continue;
            }

            // 땅이 없거나 이미 방문했던 경우면 continue
            if(map[ny][nx] == 0 || visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx);
        }
    }
}