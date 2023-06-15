import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken());

        br.close();

        long gcd = getGCD(A, B);
        System.out.println(A * B / gcd);

    }

    public static long getGCD(long a, long b){
        long r;
        while(b != 0){
            r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}