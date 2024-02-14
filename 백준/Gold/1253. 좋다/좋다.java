import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        ArrayList<Integer> givenNums = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            givenNums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(givenNums);

        int goodCnt = 0;

        for(int i = 0; i < N; i++) {

            int target = givenNums.get(i);
            int start = 0;
            int end = N - 1;

            while(start < end) {
                // start와 end인덱스 값을 합한 값(투포인터)
                int sum = givenNums.get(start) + givenNums.get(end);

                // 합이 target과 같은 경우
                if(sum == target) {
                    // start 인덱스가 현재 i와 같으면 start 인덱스 +처리
                    if(start == i) {
                        start++;
                    }
                    // end 인덱스가 현재 i와 같으면 end 인덱스 -처리
                    else if(end == i) {
                        end--;
                    }
                    // end와 start 인덱스가 i와 겹치지 않는 경우
                    else {
                        goodCnt++;
                        break;
                    }
                }
                // 합이 target보다 작으면 start 증가 처리
                else if(sum < target) {
                    start++;
                }
                // 합이 target보다 크면 end 감소 처리
                else {
                    end--;
                }
            }
        }
        bw.write(goodCnt+"");
        bw.flush();
        bw.close();
    }
}