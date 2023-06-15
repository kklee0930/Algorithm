import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int A, B;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int gcd = getGCD(A, B);
            sb.append(A * B / gcd).append("\n");
        }

        br.close();
        System.out.println(sb);
    }
    public static int getGCD(int a, int b){
        while(b != 0){
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}