import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 이전 건물의 높이가 현재 건물의 높이보다 낮으면 해당 건물의 끝으로 간주하고 pop()처리 후 건물 갯수 + 1
            while(!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                cnt++;
            }
            // 현재 건물의 높이가 이전 건물의 높이와 같으면 같은 건물로 간주하고 continue
            if(!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            stack.push(y);
        }

        // 남은 건물 pop()
        while(!stack.isEmpty()) {
            if(stack.peek() > 0) {
                cnt++;
            }
            stack.pop();
        }

        br.close();
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}