import java.util.*;
import java.io.*;

public class Main {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열 크기
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열

        br.close();

        // 한 변의 길이
        int length = (int) Math.pow(2, N);
        solution(length, r, c);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void solution(int length, int r, int c) {

        if(length == 1) {
            return;
        }
        // r,c의 위치가 2사분면
        if(r < length / 2 && c < length / 2) {
            solution(length / 2, r, c);
        }
        // r,c의 위치가 1사분면
        else if(r < length / 2 && c >= length / 2) {
            cnt += (length * length / 4);
            solution(length / 2, r, c - (length / 2));
        }
        // r,c의 위치가 3사분면
        else if(r >= length / 2 && c < length / 2) {
            cnt += (length * length / 4) * 2;
            solution(length / 2, r - (length / 2), c);
        }
        // r,c의 위치가 4사분면
        else if(r >= length / 2 && c >= length / 2) {
            cnt += (length * length / 4) * 3;
            solution(length / 2, r - (length / 2), c - (length / 2));
        }
    }
}