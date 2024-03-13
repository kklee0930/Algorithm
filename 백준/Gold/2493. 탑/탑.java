import java.io.*;
import java.util.*;

public class Main {

    // 타워 정보
    private static class Data {
        private int height;
        private int index;
        Data(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        Stack<Data> towerStack = new Stack<>();

        for(int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());

            while(!towerStack.isEmpty()) {
                Data towerData = towerStack.peek();
                // 왼쪽 타워의 높이가 현재 타워와 같거나 높으면 index출력하고 stack에 저장
                if(towerData.height >= num) {
                    sb.append(towerData.index).append(" ");
                    towerStack.push(new Data(num, i));
                    break;
                }
                // 낮으면 앞으로 필요없으므로 pop
                else {
                    towerStack.pop();
                }
            }
            if(towerStack.isEmpty()) {
                towerStack.push(new Data(num, i));
                sb.append(0).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}