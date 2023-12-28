import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int meetingCnt = Integer.parseInt(br.readLine());

        // 예약 시간 정보 담을 배열
        int[][] time = new int[meetingCnt][2];

        for(int i = 0; i < meetingCnt; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        br.close();

        // 종료시간 오름차순으로 정렬(종료 시간이 같을 경우에는 시작 시간을 오름차순으로 정렬)
        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int prevEnd = 0; // 이전 회의 종료시간
        int cnt = 0; // 회의 수

        for(int i = 0; i < time.length; i++) {
            // 현재 회의 시작시간이 이전 회의 종료시간보다 클 경우에만 회의 추가
            int currentStart = time[i][0];
            if(currentStart < prevEnd) {
                continue;
            }
            prevEnd = time[i][1];
            cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
