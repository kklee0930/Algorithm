import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 나무의 수
        M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이

        arr = new int[N]; // 나무 별 길이
        st = new StringTokenizer(br.readLine());
        br.close();

        int maxNum = 0;
        
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, num);
            arr[i] = num;
        }

        long left = 0;
        long right = maxNum;

        bw.write(binarySearch(left, right) + "");
        bw.flush();
        bw.close();
    }
    static long binarySearch(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2; // 나무를 자를 높이
            long sum = 0;

            for(int i = 0; i < N; i++) {
                if(arr[i] > mid) { // 나무의 높이가 자르는 높이보다 높은 경우에만 나무가 잘림
                    sum += arr[i] - mid;
                }
            }

            // 자른 나무 길이 합이 더 크면 나무를 자를 높이 늘리기
            // 같을 경우에도 자르는 높이를 최대화 해야 하기 때문에 높이 늘리기
            if(sum >= M) {
                left = mid + 1;
            }
            else { // 자른 나무 길이 합이 작으면 나무를 자를 높이 줄이기
                right = mid - 1;
            }
        }
        return right;
    }
}