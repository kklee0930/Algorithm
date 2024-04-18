import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1]; // input 값 저장을 위한 배열
        int[] prefixSum = new int[N + 1]; // 부분합 저장 배열
        arr[0] = 0; prefixSum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            prefixSum[i] = prefixSum[i - 1] + num;
        }

        for(int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(prefixSum[b] - prefixSum[a - 1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}