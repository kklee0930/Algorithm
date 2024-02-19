import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 갯수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 갯수

        int[] houses = new int[N]; // 집의 좌표

        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        Arrays.sort(houses);

        int left = 1; // 집 간의 최소 간격
        int right = houses[N-1]; // 집 간의 최대 간격

        while(left <= right) {
            int mid = (left + right) / 2; // 현재 최소 설치 간격
            int cnt = 1; // 설치한 공유기 갯수
            int position = 0; // 공유기를 설치한 위치

            for(int i = 1; i < N; i++) {
                // 현재 집 좌표 - 마지막으로 공유기 설치한 위치 = 설치 간격
                // 설치 간격이 최소 간격 보다 크거나 같은 경우에만 설치
                if(houses[i] - houses[position] >= mid) {
                    cnt++;
                    position = i;
                }
            }

            // 설치한 공유기 갯수가 C보다 적으면 설치 간격 줄이기
            // 최대 bound 줄이기
            if(cnt < C) {
                right = mid - 1;
            }

            // 설치한 공유기 갯수가 C보다 같거나 많아도 "허용 가능한 최대 간격" 인지 알 방법이 없기 때문에 거리 값을 늘린다.
            // 최소 bound 늘리기
            else {
                left = mid + 1;
            }
        }

        // cnt < C로 끝나기 때문에 -1
        bw.write(left - 1 + "");
        bw.flush();
        bw.close();
    }
}