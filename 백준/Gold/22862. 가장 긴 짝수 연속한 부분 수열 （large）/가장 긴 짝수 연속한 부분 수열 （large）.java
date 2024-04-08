import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 짝수 여부 확인 위한 배열
        boolean[] isEven = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            isEven[i] = (num % 2 == 0);
        }

        int maxLength = getMaxLength(N, K, isEven);
        br.close();
        bw.write(maxLength+"");
        bw.flush();
        bw.close();
    }

    private static int getMaxLength(int N, int K, boolean[] isEven) {
        int start = 0;
        int end = 0;
        int cnt = 0; // 원소 삭제 횟수
        int maxLength = 0;
        while(end < N) {

            // K의 횟수가 남아있고 홀수이면 횟수 소진하여 진행
            if(cnt < K) {
                if(!isEven[end]) {
                    cnt++;
                }
                end++;
                maxLength = Math.max(end - start - cnt, maxLength);
            }
            // end 지점 값 짝수인 경우
            else if(isEven[end]) {
                end++;
                maxLength = Math.max(end - start - cnt, maxLength);
            }
            // end 지점 홀수고 K가 이제 없을 경우 -> start 지점이 홀수일 경우 cnt--
            else {
                if(!isEven[start]) {
                    cnt--;
                }
                start++;
            }
        }
        return maxLength;
    }
}