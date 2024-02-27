import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 강의 배열(강의 시작 시간 오름차순 정렬 저장)
        Lecture[] lectures = new Lecture[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        br.close();
        Arrays.sort(lectures);

        // 우선순위 큐(강의 종료 시간 오름차순 정렬 저장)
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0].end);

        // 현재 강의의 시작시간과 이전 강의의 종료시간 비교해서 강의실 추가 및 제거
        for(int i = 1; i < N; i++) {
            int endTime = pq.peek(); // 이전 강의의 종료시간
            int startTime = lectures[i].start; // 현재 강의의 시작시간

            // 강의가 겹치지 않으면 강의실 추가할 필요 없음
            if(startTime >= endTime) {
                pq.poll();
            }
            pq.add(lectures[i].end);
        }

        bw.write(pq.size() + "");
        bw.flush();
        bw.close();
    }
}