import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 파티장의 크기, 손님 수
        int M = Integer.parseInt(st.nextToken()); 

        graph = new int[N + 1][N + 1];
        
        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            if(graph[start][end] <= limit) {
                bw.write("Enjoy other party\n");
            }
            else {
                bw.write("Stay here\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static void floydWarshall() {
        // k노드를 거쳐가는 경우를 계산
        for(int k = 1; k < N + 1; k++) {
            for(int l = 1; l < N + 1; l++) {
                for(int m = 1; m < N + 1; m++) {
                    graph[l][m] = Math.min(graph[l][m], graph[l][k] + graph[k][m]);
                }
            }
        }
    }
}