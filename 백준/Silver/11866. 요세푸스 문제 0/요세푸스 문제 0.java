import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();

        sc.close();
        
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){ // 1부터 N까지 숫자가 포함된 queue 생성
            queue.addLast(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(queue.size() > 1){
            for(int i = 1; i < K; i++){
                queue.addLast(queue.removeFirst());
            }
            sb.append(queue.removeFirst()).append(", ");
        }

        sb.append(queue.remove()).append(">");
        System.out.println(sb);
    }
}