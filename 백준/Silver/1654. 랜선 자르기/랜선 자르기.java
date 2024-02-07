import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K]; // 각 랜선의 길이를 저장하기 위한 배열
        long max = 0;
        long min = 0;
        long mid = 0;

        for(int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;

            if(max < num) { // 기존 최댓값이 더 작으면 재설정
                max = num;
            }
        }
        br.close();
        max++;

        while(min < max) {

            // 이분탐색 중간값 구하기
            mid = (max + min) / 2;

            long count = 0;

            for(int i = 0; i < arr.length; i++) { //
                count += (arr[i] / mid); // mid 길이로 자를 수 있는 갯수
            }

            if(count >= N) { // 목표 갯수보다 자른 수가 더 많으면 자르는 길이 증가(최솟값 증가)
                min = mid + 1;
            }
            else { // 자른 수가 더 적으면 자르는 길이 감소(최댓값 감소)
                max = mid;
            }
        }
        bw.write(min - 1 + "");
        bw.flush();
        bw.close();
    }
}