import java.io.*;
import java.util.*;

public class Main {

    static ArrayDeque<String> dq = new ArrayDeque<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            queueCmd(cmd);
        }
        br.close();
        System.out.println(sb.toString());
    }

    static void queueCmd(String word) {
        switch (word) {
            case "push":
                dq.add(st.nextToken());
                break;

            case "pop":
                if (dq.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(dq.remove());
                }
                sb.append("\n");
                break;

            case "size":
                sb.append(dq.size()).append("\n");
                break;

            case "empty":
                if (dq.isEmpty()) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                break;

            case "front":
                if (dq.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(dq.peek());
                }
                sb.append("\n");
                break;

            case "back":
                if (dq.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(dq.peekLast());
                }
                sb.append("\n");
                break;
        }
    }
}