import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N+1][M+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int k = 0; k < K; k++) {

            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = 0;

            // i,j 좌표부터 x,y 좌표 사이에 있는 원소를 모두 더한다.
            for(int row = i; row <= x; row++) {

                for(int col = j; col <= y; col++) {
                    sum += array[row][col];
                }
            }
            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}