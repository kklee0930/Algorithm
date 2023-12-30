import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 주어진 input을 -를 기준으로 분리
        String[] input = br.readLine().split("-");

        for(int i=0; i < input.length; i++) {
            // -를 기준으로 분리한 것들 중 + 연산이 들어있으면 sum처리
            String[] divided = input[i].split("\\+");
            int[] tempArray = Arrays.stream(divided).mapToInt(Integer::parseInt).toArray();
            input[i] = String.valueOf(Arrays.stream(tempArray).sum());
        }

        br.close();

        int result = 0;
        for(int i = 0; i < input.length; i++) {
            if(i == 0) {
                result += Integer.parseInt(input[i]);
            }
            else {
                result -= Integer.parseInt(input[i]);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
