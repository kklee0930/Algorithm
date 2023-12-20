import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> heap = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 연산의 갯수
        heap.add(0); // 인덱스 1부터 시작하기 위한 0 추가

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 배열에서 가장 작은 값 출력 및 제거
            if(num == 0) {
                remove();
            }
            // 배열에 값 추가
            else {
                insert(num);
            }
        }

        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static void remove() {

        // 빈 heap일경우 0출력
        if(heap.size() < 2) {
            sb.append(0).append("\n");
        }
        else {
            // 루트값 삭제 후 마지막 인덱스의 값으로 초기화
            int rootValue = heap.get(1);
            sb.append(rootValue).append("\n");
            heap.set(1, heap.get(heap.size()-1));
            // 마지막 힙 값 삭제
            heap.remove(heap.size() - 1);

            // 루트의 인덱스
            int parentIdx = 1;

            // 자식노드가 존재할 경우
            while(parentIdx * 2 < heap.size()) {

                int parentValue = heap.get(parentIdx); // 부모노드 값
                int childValue = heap.get(parentIdx * 2); // 왼쪽 자식노드 값
                int childIdx = parentIdx * 2; // 왼쪽 자식노드의 인덱스

                // 오른쪽 자식노드가 존재하고 오른쪽 자식노드값이 왼쪽 자식노드값보다 작다면
                if(heap.size() > parentIdx*2 + 1 && childValue > heap.get(parentIdx*2 + 1)) {
                    childIdx = parentIdx * 2 + 1;
                    childValue = heap.get(parentIdx*2 + 1);
                }

                // 부모노드 값이 자식노드 값보다 작은 경우 종료
                if(heap.get(parentIdx) < heap.get(childIdx)) {
                    break;
                }

                // 부모자식 서로 위치 변경
                heap.set(parentIdx, childValue);
                heap.set(childIdx, parentValue);

                // 위치 변경돼서 인덱스 초기화
                parentIdx = childIdx;
            }
        }
    }
    private static void insert(int num) {

        // 힙의 마지막 인덱스에 값 추가
        heap.add(num);
        // 힙의 마지막 인덱스
        int childIdx = heap.size() - 1;

        // 힙 크기가 1 초과이고 부모노드가 자식노드보다 클 경우
        while(childIdx > 1 && heap.get(childIdx) < heap.get(childIdx/2)) {

            int parentValue = heap.get(childIdx/2);
            int parentIdx = childIdx / 2;
            // 부모자식 서로 위치 변경
            heap.set(parentIdx, num);
            heap.set(childIdx, parentValue);

            // 위치 변경돼서 인덱스 초기화
            childIdx /= 2;
        }
    }
}