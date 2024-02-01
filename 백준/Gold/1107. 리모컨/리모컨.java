import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = sc.next();
        int M = sc.nextInt();

        boolean[] invalid = new boolean[10]; // 0~9중 고장난 버튼

        for(int i = 0; i < M; i++) {
            int num = sc.nextInt();
            invalid[num] = true; // 고장난 버튼 true 처리
        }

        // +, - 버튼만 사용해서 이동하는 경우
        int minValue = Math.abs(Integer.parseInt(N) - 100);

        // 최대값이 500,000이므로 6자리를 최댓값으로 설정한 999,999까지 iteration
        for(int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);
            int leng = num.length();

            // 문자열 iteration
            for(int j = 0; j < leng; j++) {
                // num에 고장나서 누를 수 없는 버튼이 존재하면 break
                if(invalid[num.charAt(j) - '0']) {
                    break;
                }
                // 모두 누를 수 있다면
                else if(j == leng - 1) {
                    // 현재 누른 번호(i) - 목표 번호(Integer.parseInt(N)) -> +, - 버튼 눌러야 하는 횟수
                    // leng -> 숫자 버튼 누르는 횟수
                    minValue = Math.min(minValue, Math.abs(i - Integer.parseInt(N)) + leng);
                }
            }
        }

        bw.write(minValue + "");
        bw.flush();
        bw.close();
    }
}