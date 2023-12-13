import java.io.*;
import java.util.*;

public class Main {

    static int infectedCnt;
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 컴퓨터의 수
        int computerCnt = Integer.parseInt(br.readLine());

        // 연결되어 있는 컴퓨터의 쌍의 수
        int edgeCnt = Integer.parseInt(br.readLine());

        // 간선 정보 저장할 graph
        for(int i = 0; i < computerCnt+1; i++) {
            graph.add(new ArrayList<>());
        }

        // 방문 기록 저장할 배열
        visited = new boolean[computerCnt+1];

        for(int i = 0; i < edgeCnt; i++) {

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 양방향이기 때문에 양쪽으로 저장
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        br.close();

        infectedCnt = 0;
        bfs(1);
        bw.write(String.valueOf(infectedCnt));

        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {

        visited[start] = true;

        queue.addLast(start);

        while(!queue.isEmpty()) {
            int currentNode = queue.removeFirst();
            for(int adjacentNode : graph.get(currentNode)) {

                if(!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    infectedCnt++;
                    queue.addLast(adjacentNode);
                }
            }
        }
    }
}