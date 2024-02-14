import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 휴게소 갯수
        int M = Integer.parseInt(st.nextToken()); // 더 지을 휴게소 갯수
        int L = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0); // 고속도로 시작지점
        arr.add(L); // 고속도로 끝 지점
        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        int left = 1;
        int right = L - 1;

        while(left <= right) {
            int mid = (left + right) / 2; // 휴게소 설치 간격
            int sum = 0; // 설치 가능한 휴게소 갯수

            for(int i = 1; i < arr.size(); i++) {
                // 구간 별 휴게소 설치 간격 기준으로 설치 가능한 휴게소 수
                // -1은 휴게소가 차지하는 거리
                sum += (arr.get(i) - arr.get(i-1) - 1) / mid;
            }

            if(sum > M) { // 설치 가능한 수가 M을 넘어버리면 mid 늘리기
                left = mid + 1;
            }
            else { // 설치 가능한 수가 M보다 부족하면 mid 줄이기
                right = mid - 1;
            }
        }

        bw.write(left + "");
        bw.flush();
        bw.close();
    }
}