import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 현재 메인 대기줄
        int[] currentLine = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            currentLine[i] = number;
        }

        br.close();

        // 임시 대기줄
        Stack<Integer> tempLine = new Stack<>();

        int prevNum = 0; // 이전 번호
        boolean isFail = false;

        for(int i = 0; i < n; i ++) {
            // 메인 대기열의 번호
            int currentNum = currentLine[i];

            // 순서가 맞으면 그대로 간식 수령
            if(currentNum == prevNum + 1) {
                prevNum = currentNum;
            }
            // 순서에 맞지 않으면
            else {
                // 임시 대기열 번호가 다음 번호에 해당하면 제거
                if(!tempLine.isEmpty() && tempLine.peek() == prevNum + 1) {
                    prevNum = tempLine.pop();
                    // ❗임시대기열에서 순서에 맞는 번호를 제거한 것이라서 해당 메인 대기열의 번호처리를 다시 해줘야 함.
                    i--;
                }
                else {
                    tempLine.add(currentNum);
                }
            }
        }

        for(int i = 0; i < tempLine.size(); i++) {
            int lastTempVal = tempLine.pop();

            // 임시 대기열에서 pop한 값이 순서와 맞지 않으면 실패
            if(lastTempVal != prevNum + 1) {
                isFail = true;
                break;
            }
            else {
                prevNum = lastTempVal;
            }
        }
        System.out.println(isFail ? "Sad" : "Nice");
    }
}