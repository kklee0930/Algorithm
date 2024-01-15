import java.io.*;
import java.util.*;

public class Main {

    static long start;
    static long goal;
    static ArrayDeque<Long> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        start = Long.parseLong(st.nextToken());
        goal = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(bfs(start)));
        bw.flush();
        bw.close();
    }

    static int bfs(long currentNum) {

        int cnt = 0;
        deque = new ArrayDeque<>();
        deque.add(currentNum);

        while(!deque.isEmpty()) {
            int dqSize = deque.size();

            for(int i = 0; i < dqSize; i++) {
                long currentNumber = deque.removeFirst();
                if(currentNumber == goal) {
                    return cnt+1;
                }

                // 2곱하기 연산
                if(currentNumber * 2 <= goal) {
                    deque.add(currentNumber * 2);
                }
                // 가장 오른쪽에 1 더하기 연산
                if(currentNumber * 10 + 1 <= goal) {
                    deque.add(currentNumber * 10 + 1);
                }
            }

            cnt++;
        }
        return -1;
    }
}