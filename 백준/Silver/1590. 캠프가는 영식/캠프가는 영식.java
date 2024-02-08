import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Long> busArrivalTimes;
    static long T;

    static long binarySearch() {

        long result;

        // 막차보다 늦게 도착하면 버스 못탐
        if(busArrivalTimes.get(busArrivalTimes.size() - 1) < T) {
            result = -1;
        }
        // 첫차시간이 도착시간과 같거나 더 클 경우
        else if(busArrivalTimes.get(0) >= T) {
            result = busArrivalTimes.get(0) - T;
        }
        else {
            // 이분탐색
            long left = 0;
            long right = busArrivalTimes.size() - 1;
            long mid;

            while(left < right) {
                mid = (left + right) / 2;

                if(busArrivalTimes.get((int)mid) == T) {
                    return 0;
                }
                else if(busArrivalTimes.get((int)mid) > T) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            result = busArrivalTimes.get((int)right) - T;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken()); // 버스 갯수
        T = Long.parseLong(st.nextToken()); // 출발 시간

        busArrivalTimes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long startTime = Long.parseLong(st.nextToken()); // 버스 시작 시각
            long interval = Long.parseLong(st.nextToken()); // 버스 간격
            long busCnt = Long.parseLong(st.nextToken()); // 버스 대수

            for(int j = 0; j < busCnt; j++) {
                busArrivalTimes.add(startTime + (interval * j));
            }
        }
        // 시간순 정렬
        Collections.sort(busArrivalTimes);

        bw.write(binarySearch() + "");
        bw.flush();
        bw.close();
    }
}