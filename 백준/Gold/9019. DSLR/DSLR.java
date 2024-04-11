import java.util.*;
import java.io.*;

public class Main {
    static String[] cmd = {"D", "S", "L", "R"};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int initialVal = Integer.parseInt(st.nextToken());
            int finalVal = Integer.parseInt(st.nextToken());

            bfs(initialVal, finalVal);
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static void bfs(int initialVal, int finalVal) {
        boolean[] visited = new boolean[10000];
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(initialVal, ""));
        visited[initialVal] = true;

        while(!queue.isEmpty()) {
            Data curr = queue.poll();

            int currNum = curr.currentNum;
            String currCmd = curr.cmd;

            if(currNum == finalVal) {
                sb.append(currCmd).append("\n");
                break;
            }

            if(!visited[curr.D()]) {
                queue.offer(new Data(curr.D(), currCmd + "D"));
                visited[curr.D()] = true;
            }
            if(!visited[curr.S()]) {
                queue.offer(new Data(curr.S(), currCmd + "S"));
                visited[curr.S()] = true;
            }
            if(!visited[curr.L()]) {
                queue.offer(new Data(curr.L(), currCmd + "L"));
                visited[curr.L()] = true;
            }
            if(!visited[curr.R()]) {
                queue.offer(new Data(curr.R(), currCmd + "R"));
                visited[curr.R()] = true;
            }
        }
    }

    static class Data {
        int currentNum;
        String cmd;

        Data(int currentNum, String cmd) {
            this.currentNum = currentNum;
            this.cmd = cmd;
        }

        int D() {
            return currentNum * 2 % 10000;
        }

        int S() {
            return currentNum == 0 ? 9999 : currentNum - 1;
        }

        int L() {
            return currentNum % 1000 * 10 + currentNum / 1000;
        }

        int R() {
            return currentNum % 10 * 1000 + currentNum / 10;
        }
    }
}