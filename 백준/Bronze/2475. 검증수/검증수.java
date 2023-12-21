import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        br.close();

        for(int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += (int) Math.pow(num, 2);
        }

        bw.write(String.valueOf(sum % 10));
        bw.flush();
        bw.close();
    }
}