import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        long[] gasPrice = new long[N]; // 도시별 기름값
        long[] distance = new long[N-1]; // 다음도시간 거리

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N - 1; i++) {
            long d = Integer.parseInt(st.nextToken());
            distance[i] = d;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            long price = Integer.parseInt(st.nextToken());
            gasPrice[i] = price;
        }

        br.close();

        long totalCost = 0; // 총 기름값
        long minCost = gasPrice[0]; // 기름가격 최소값

        for(int i = 0; i < N - 1; i++) {
            if(minCost > gasPrice[i]) { // 다음 방문한 도시의 기름이 더 싸면 초기화
                minCost = gasPrice[i];
            }
            totalCost += minCost * distance[i]; // 최소값 * 거리
        }

        bw.write(String.valueOf(totalCost));
        bw.flush();
        bw.close();
    }
}
