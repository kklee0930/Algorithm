import java.io.*;
import java.util.*;

public class Main {

    private static int[] graph;
    private static int[] diceCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        graph = new int[101];
        diceCnt = new int[101];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // x칸에 도달하면 y칸으로 이동(사다리, 낮은칸에서 높은 칸으로 이동)
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x] = y;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // u칸에 도달하면 v칸으로 이동(뱀, 높은칸에서 낮은칸으로 이동)
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u] = v;
        }

        br.close();

        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
    }

    private static int bfs() {

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1); // queue에는 현재 위치 저장
        diceCnt[1] = 0; // 주사위 굴린 횟수 저장

        while(!queue.isEmpty()) {
            int currentCoord = queue.poll();

            // 사다리나 뱀이 있다면 해당 좌표로 이동
            if(graph[currentCoord] != 0) {

                // 새롭게 이동할 좌표
                int newCoord = graph[currentCoord];

                // 이동한 좌표의 주사위 던진 횟수 동기화
                diceCnt[newCoord] = diceCnt[currentCoord];
                currentCoord = newCoord;
            }

            // 목표지점 100 도달 시 종료
            if(currentCoord == 100) {
                return diceCnt[currentCoord];
            }

            // 주사위 던지기(1~6까지)
            for(int diceRoll = 1; diceRoll < 7; diceRoll++) {
                int nextCoord = currentCoord + diceRoll;
                if(nextCoord < 101 && diceCnt[nextCoord] == 0) {
                    diceCnt[nextCoord] = diceCnt[currentCoord] + 1;
                    queue.add(nextCoord);
                }
            }
        }
        return 0;
    }
}