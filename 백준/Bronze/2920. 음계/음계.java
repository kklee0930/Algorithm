import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int prevNum = -1;
        boolean ascFlag = false;
        boolean descFlag = false;

        for(int i = 0; i < 8; i++) {

            int number = Integer.parseInt(st.nextToken());

            if(i == 0) {
                prevNum = number;
                continue;
            }
            // 이전 숫자가 현재 숫자보다 크면 내림차순
            if(prevNum > number) {
                descFlag = true;
            }
            // 이전 숫자가 현재 숫자보다 작으면 오름차순
            else {
                ascFlag = true;
            }
            prevNum = number;
        }

        if(ascFlag && !descFlag) {
            bw.write("ascending");
        }
        else if(!ascFlag && descFlag) {
            bw.write("descending");
        }
        else {
            bw.write("mixed");
        }
        bw.flush();
        bw.close();
    }
}
