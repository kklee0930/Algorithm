import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2]; // 강의 시작과 끝 시간 저장 배열
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            time[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        // 시작 순서 오름차순, 종료 순서 오름차순 정렬
        Arrays.sort(time, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            else {
                return o1[0] - o2[0];
            }
        });

        br.close();
        room.add(time[0][1]);
        // 시간대가 겹치지 않으면 room.poll(), 시간대가 겹치면 room.add()만 해서 강의실 추가
        for(int i = 1; i < N; i++) {
            if(room.peek() <= time[i][0]) {
                room.poll();
            }
            room.add(time[i][1]);
        }
        bw.write(room.size()+"");
        bw.flush();
        bw.close();
    }
}