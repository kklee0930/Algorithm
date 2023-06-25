import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push_front":
                    queue.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(queue.isEmpty()){
                        sb.append(-1);
                    }
                    else{
                        sb.append(queue.removeFirst());
                    }
                    sb.append("\n");
                    break;

                case "pop_back":
                    if(queue.isEmpty()){
                        sb.append(-1);
                    }
                    else{
                        sb.append(queue.removeLast());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1);
                    }
                    else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1);
                    }
                    else {
                        sb.append(queue.peekFirst());
                    }
                    sb.append("\n");
                    break;

                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1);
                    }
                    else {
                        sb.append(queue.peekLast());
                    }
                    sb.append("\n");
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}