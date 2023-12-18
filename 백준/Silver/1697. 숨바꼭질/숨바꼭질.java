import java.io.*;
import java.util.*;

public class Main {

    private static final int[] visited = new int[100001];
    private static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int N = Integer.parseInt(st.nextToken()); // 시작점
        K = Integer.parseInt(st.nextToken()); // 목적지

        bfs(N);
        bw.write(String.valueOf(visited[K]));
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(start);
        visited[start] = 0;

        while(!queue.isEmpty()) {

            int current = queue.removeFirst();

            // 목적지 도달하면 종료
            if(current == K) {
                return;
            }

            // 방문이력 없고 현재 위치-1 했을 때 범위 벗어나지 않는다면 방문 처리
            if(current > 0 && visited[current-1] == 0) {
                visited[current-1] = visited[current] + 1;
                queue.addLast(current - 1);
            }
            // 방문이력 없고 현재 위치+1 했을 때 범위 벗어나지 않는다면 방문 처리
            if(current < 100000 && visited[current+1] == 0) {
                visited[current+1] = visited[current] + 1;
                queue.addLast(current + 1);
            }
            // 방문이력 없고 현재 위치*2 했을 때 범위 벗어나지 않는다면 방문 처리
            if(current * 2 < 100001 && visited[current*2] == 0) {
                visited[current*2] = visited[current] + 1;
                queue.addLast(current * 2);
            }
        }
    }
}