import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, C));
    }
    static long solution(long a, long b, long c) {

        // a의 0제곱이면 1
        if(b == 0) {
            return 1;
        }
        // b가 홀수 제곱이면 lower(b/2) * a값을 해줘야함
        if(b % 2 == 1) {
            return a * solution(a, b - 1, c) % c;
        }
        long temp = solution(a, b / 2, c) % c;
        return temp * temp % c;
    }
}