import java.io.*;
import java.util.*;

public class Main {

    private static int[][] visited;
    private static int length;
    private static int endX;
    private static int endY;
    private static final int[][] knightMove =
            {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 케이스 갯수
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {

            // 체스판 한 변의 길이
            length = Integer.parseInt(br.readLine());
            visited = new int[length][length];

            st = new StringTokenizer(br.readLine());
            // 시작점
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 도착점
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            bfs(new int[]{startX, startY});
            bw.write(visited[endX][endY] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int[] start) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 시작점이 목적지점과 같으면 return
        if(start[0] == endX && start[1] == endY) {
            return;
        }

        queue.addLast(start);

        while(!queue.isEmpty()) {
            int[] current = queue.removeFirst();

            for(int[] data : knightMove) {
                int nx = current[0] + data[0];
                int ny = current[1] + data[1];

                // 범위 벗어나지 않고 방문이력 없는지 체크
                if(nx >= 0 && nx < length && ny >= 0 && ny < length && visited[nx][ny] == 0) {
                    // 방문처리
                    visited[nx][ny] = visited[current[0]][current[1]] + 1;

                    // 목적지 도달하면 return
                    if(nx == endX && ny == endY) {
                        return;
                    }

                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}