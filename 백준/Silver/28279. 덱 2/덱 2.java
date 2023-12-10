import java.io.*;
import java.util.*;

public class Main {

    static Deque<String> deque = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmdOperator(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb.toString());

    }

    public static void cmdOperator(int cmd) {

        switch(cmd) {
            case 1:
                deque.addFirst(st.nextToken());
                break;
            case 2:
                deque.addLast(st.nextToken());
                break;
            case 3:
                if(!deque.isEmpty()) {
                    sb.append(deque.removeFirst()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                break;
            case 4:
                if(!deque.isEmpty()) {
                    sb.append(deque.removeLast()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                break;
            case 5:
                sb.append(deque.size()).append("\n");
                break;
            case 6:
                if(deque.isEmpty()) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
                break;
            case 7:
                if(!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                break;
            case 8:
                if(!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
                break;
        }
    }
}