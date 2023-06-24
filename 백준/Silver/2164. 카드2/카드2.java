import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.close();

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){ // 1부터 N까지 숫자가 저장된 queue 생성
            queue.addFirst(i);
        }

        while(queue.size() > 1){
            queue.removeLast(); // 가장 위의 숫자를 제거하고
            if(queue.size() == 1){ // 숫자 제거시 queue의 길이가 1이면 종료
                break;
            }
            queue.addFirst(queue.removeLast()); // queue의 가장 윗 숫자를 가장 아래로 이동
        }

        for(int elem: queue){
            System.out.println(elem);
        }
    }
}