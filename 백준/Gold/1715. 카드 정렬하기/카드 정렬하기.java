import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        br.close();

        // 매번 가장 작은 숫자 두개(Priority Queue 사용)를 뽑아서 더해야 함
        // Priority Queue 사용 시 매번 뽑는 값이 최소임을 보장함
        int sum = 0;
        while(pq.size() > 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            pq.add(min1 + min2);
            sum += min1 + min2;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}