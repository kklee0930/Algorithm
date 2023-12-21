import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> heap = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        heap.add(0); // 인덱스 1부터 시작하기 위해서

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                remove();
            }
            else {
                insert(num);
            }
        }

        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void insert(int number) {

        heap.add(number);

        // 비교 기준이 되는 초기 자식노드 인덱스
        int childIdx = heap.size() - 1;

        // 부모노드 존재하는 경우
        while(childIdx / 2 >= 1) {
            int parentIdx = childIdx / 2;
            int parentValue = heap.get(parentIdx);

            if(number > parentValue) { // 자식노드 값이 부모노드 값보다 크면 스왑
                heap.set(childIdx, parentValue);
                heap.set(parentIdx, number);
                childIdx /= 2; // 비교 기준이 되는 자식노드 인덱스 초기화
            }
            else {
                break;
            }
        }
    }

    private static void remove() {

        // 배열이 비면 0 출력
        if(heap.size() < 2) {
            sb.append("0").append("\n");
        }
        else {
            // 가장 큰 값 제거
            int rootValue = heap.get(1);
            sb.append(rootValue).append("\n");

            // 마지막 노드를 루트 노드로 설정 / 마지막 노드 제거
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int parentIdx = 1;

            // 자식 노드가 존재할 때
            while(parentIdx * 2 < heap.size()) {

                // 부모노드 값
                int parentValue = heap.get(parentIdx);

                // 왼쪽 자식 노드
                int childIdx = parentIdx * 2;
                int childValue = heap.get(childIdx);

                // 오른쪽 자식 노드가 존재하고 값이 왼쪽 노드 값보다 크면 교체
                if(parentIdx * 2 + 1 < heap.size() && heap.get(parentIdx*2 + 1) > childValue) {
                    childIdx = parentIdx*2 + 1;
                    childValue = heap.get(parentIdx*2 + 1);
                }

                // 자식노드 값이 부모 노드 값보다 크면 스왑
                if(childValue > parentValue) {
                    heap.set(parentIdx, childValue);
                    heap.set(childIdx, parentValue);
                    parentIdx = childIdx;
                }
                else {
                    break;
                }
            }
        }
    }
}