import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int total = Integer.parseInt(st.nextToken()); // 동전 가치의 합
        int cnt = 0;

        int[] coinArray = new int[N]; // 동전 종류 저장하는 배열(내림차순)
        for(int i = N - 1; i > -1; i--) {
            coinArray[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for(int j = 0; j < N; j++) {
            // 동전 금액이 남은 가치의 합보다 크면 continue
            if(coinArray[j] > total) {
                continue;
            }
            cnt += total / coinArray[j];
            total %= coinArray[j];

            if(total == 0) {
                break;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
