import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int m;
    static int startRow;
    static int startCol;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] graph;
    static int[][] distance;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        // graph에 값 저장 
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2) {
                    startRow = i;
                    startCol = j;
                }
                graph[i][j] = num;
            }
        }
        br.close();
        
        bfs(startRow, startCol);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    sb.append("-1 ");
                }
                else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int k = 0; k < 4; k++) {
                int nx = row + dx[k];
                int ny = col + dy[k];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }
                if(graph[nx][ny] == 0) {
                    distance[nx][ny] = 0;
                    visited[nx][ny] = true;
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                distance[nx][ny] = distance[row][col] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}