import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getPercentage(X, Y);

        if(X == Y) {
            bw.write(-1 + "");
        }
        else {
            int cnt = -1;
            int left = 0;
            int right = 1000000000;

            while(left <= right) {
                int mid = (left + right) / 2;
                // 목표값 Z와 일치하면 변할 때까지 진행
                if(getPercentage(X + mid, Y + mid) == Z) {
                    left = mid + 1;
                }
                // Z와 불일치 시 조건 충족, 게임 횟수 최소화 시도해보기
                else {
                    cnt = mid;
                    right = mid - 1;
                }
            }
            bw.write(cnt+"");
        }
        bw.flush();
        bw.close();
    }

    static int getPercentage(int x, int y) {
        return (int)((long)y * 100 / (long)x);
    }
}