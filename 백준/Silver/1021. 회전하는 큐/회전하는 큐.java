import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), M = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            queue.addLast(i);
        }

        // 첫번째 원소 뽑아내기: removefirst
        // 왼쪽으로 한칸 이동하기: queue.addlast(queue.removefirst)
        // 오른쪽으로 한칸 이동하기: queue.addfirst(queue.removelast)

        int num;
        int cnt = 0;
        int idx;
        for(int i = 0; i < M; i++){
            num = sc.nextInt();
            if(queue.peekFirst() != num){ // 첫 원소가 같지 않으면
                idx = queue.indexOf(num); // 찾으려고 하는 원소의 index구하기

                // idx = 왼쪽으로 이동해야하는 횟수, N-idx = 오른쪽으로 이동해야하는 횟수
                // 더 짧은 쪽으로 이동 실시
                if(idx < N - idx){
                    while(queue.peekFirst() != num){
                        queue.addLast(queue.removeFirst());
                        cnt++;
                    }
                }
                else {
                    while(queue.peekFirst() != num){
                        queue.addFirst(queue.removeLast());
                        cnt++;
                    }
                }
            }
            queue.removeFirst(); // 원소 제거
            N--; // 원소를 하나 제거했으므로 queue 길이--
        }

        sc.close();
        System.out.println(cnt);
    }
}