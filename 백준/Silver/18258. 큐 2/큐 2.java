import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()){
                case "push":
                    queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    Integer num = queue.pollFirst();
                    if(num == null){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(num).append("\n");
                    }
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front":
                    Integer front = queue.peek();
                    if(front == null){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(front).append("\n");
                    }
                    break;

                case "back":
                    Integer back = queue.peekLast();
                    if(back == null){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(back).append("\n");
                    }
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}