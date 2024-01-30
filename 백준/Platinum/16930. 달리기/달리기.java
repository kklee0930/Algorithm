import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int endX;
    static int endY;
    static String[][] graph;
    static int[][] visited;

    static class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 1초에 이동가능 최대 거리

        visited = new int[N+1][M+1]; // 방문여부 및 소요시간 저장
        graph = new String[N+1][M+1]; // 체육관 구조
        for(int i = 1; i < N + 1; i++) {
            String[] input = br.readLine().split("");
            for(int j = 1; j < M + 1; j++) {
                graph[i][j] = input[j-1];
            }
        }

        st = new StringTokenizer(br.readLine());
        br.close();

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        System.out.println(bfs(new Coord(startX, startY)));
    }

    static int bfs(Coord coordinate) {

        if(coordinate.x == endX && coordinate.y == endY) {
            return 0;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Coord> queue = new LinkedList<>();
        queue.add(coordinate);

        while(!queue.isEmpty()) {
            Coord currentCoord = queue.poll();
            int currentX = currentCoord.x;
            int currentY = currentCoord.y;

            for(int i = 0; i < 4; i++) { // 델타탐색
                for(int j = 1; j < K + 1; j++) { // i방향으로 1부터 k값만큼 거리이동
                    int nx = currentX + (j * dx[i]);
                    int ny = currentY + (j * dy[i]);

                    if(nx < 1 || nx > N || ny < 1 || ny > M) { // 범위 벗어나지 않는지 체크
                        break;
                    }
                    if(graph[nx][ny].equals("#")) { // 벽인지 체크
                        break;
                    }
                    if(visited[nx][ny] == 0) { // 방문하지 않았다면 queue에 추가 및 시간 저장

                        visited[nx][ny] = visited[currentX][currentY] + 1;
                        // 목적지 도달 시에 소요시간 출력
                        if(nx == endX && ny == endY) {
                            return visited[nx][ny];
                        }
                        queue.add(new Coord(nx, ny));
                    }
                    // 재방문의 경우 방문 좌표의 값이 기존 좌표의 값보다 작으면 더 이상 진해할 필요 없음
                    else if(visited[nx][ny] <= visited[currentX][currentY]) {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}