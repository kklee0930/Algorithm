import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        // 첫번째 줄에서 주어지는 값 삽입
        maxDp[0] = n1; minDp[0] = n1;
        maxDp[1] = n2; minDp[1] = n2;
        maxDp[2] = n3; minDp[2] = n3;

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            n3 = Integer.parseInt(st.nextToken());

            // 인덱스 별로 dp활용해서 값 갱신
            int tempMax0 = Math.max(maxDp[0], maxDp[1]) + n1;
            int tempMax1 = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + n2;
            int tempMax2 = Math.max(maxDp[1], maxDp[2]) + n3;

            int tempMin0 = Math.min(minDp[0], minDp[1]) + n1;
            int tempMin1= Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + n2;
            int tempMin2 = Math.min(minDp[1], minDp[2]) + n3;

            maxDp[0] = tempMax0; minDp[0] = tempMin0;
            maxDp[1] = tempMax1; minDp[1] = tempMin1;
            maxDp[2] = tempMax2; minDp[2] = tempMin2;
        }

        br.close();

        bw.write(Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + " " + Math.min(Math.min(minDp[0], minDp[1]), minDp[2]));
        bw.flush();
        bw.close();
    }
}