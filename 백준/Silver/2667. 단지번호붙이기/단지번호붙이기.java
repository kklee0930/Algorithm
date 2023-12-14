import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static ArrayList<Integer> numOfHouse = new ArrayList<>();
    static boolean flag = false;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int x, y;
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 지도의 크기
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        map = new int[N][N];

        // map에 각 위치의 원소 저장
        for(int i = 0; i < N; i++) {

            String row = br.readLine();

            for(int j = 0; j < row.length(); j++) {

                map[i][j] = row.charAt(j) - '0';
            }
        }

        br.close();

        x = 0;
        y = 0;
        bfs(x, y);

        // 각 단지내 집 수 오름차순 정렬
        Collections.sort(numOfHouse);

        StringBuilder sb = new StringBuilder();
        sb.append(numOfHouse.size()).append("\n");

        for(int houseCnt : numOfHouse) {
            sb.append(houseCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {

        for(int i = x; i < N; i++) {
            for(int j = y; j < N; j++) {

                // 해당 좌표에 집이 존재하고 방문하지 않았다면
                if(map[i][j] == 1 && !visited[i][j]) {

                    cnt = 1;

                    // 큐에 해당 좌표값 저장
                    queue.addLast(new int[]{i, j});

                    // 방문처리
                    visited[i][j] = true;
                }

                while(!queue.isEmpty()) {

                    // 단지내에서 게산중임을 알리는 flag
                    flag = true;

                    // queue의 가장 아래 x, y값 추출
                    int xCoord = queue.peekFirst()[0];
                    int yCoord = queue.peekFirst()[1];
                    queue.removeFirst();

                    // 상하좌우 인접한 집 존재하는지 체크
                    for(int k = 0; k < 4; k++) {

                        int nx = xCoord + dx[k];
                        int ny = yCoord + dy[k];

                        // 지도 범위를 벗어나지 않는지 체크
                        if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            // 해당 좌표에 집이 존재하고 방문하지 않았는지 체크
                            if(map[nx][ny] == 1 && !visited[nx][ny]) {

                                // 방문 처리 후 cnt++ 하고 queue에 좌표값 저장
                                queue.addLast(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                cnt++;
                            }
                        }
                    }
                }

                // 하나의 단지를 방문했다면 배열에 집 갯수 추가
                if(flag) {
                    numOfHouse.add(cnt);
                    flag = false;
                }
            }
        }
    }
}