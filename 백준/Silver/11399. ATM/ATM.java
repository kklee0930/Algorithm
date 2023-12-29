import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int customerCnt = Integer.parseInt(br.readLine());
        int[] customers = new int[customerCnt];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < customerCnt; i++) {
            customers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(customers);

        int temp = 0;
        int sum = 0;
        for(int i = 0; i < customerCnt; i++) {
            temp += customers[i];
            sum += temp;
        }

        br.close();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
