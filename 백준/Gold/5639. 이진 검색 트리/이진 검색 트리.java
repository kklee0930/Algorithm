import java.util.*;
import java.io.*;

class Main {
    static List<Integer> arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new ArrayList<>();
        String inputData;

        // 입력 데이터가 없을 때까지 받기
        while((inputData = br.readLine()) != null && !inputData.isEmpty()) {
            arr.add(Integer.parseInt(inputData));
        }

        solution(arr);
    }

    static void solution(List<Integer> arr) {

        // 입력배열의 길이가 0이면 종료
        if(arr.size() == 0) {
            return;
        }

        // 왼쪽, 오른쪽 서브트리
        List<Integer> leftSubTree = new ArrayList<>();
        List<Integer> rightSubTree = new ArrayList<>();

        int root = arr.get(0);

        boolean flag = false;
        // 전위 순회 시 루트보다 작은 왼쪽 노드 값이 항상 먼저 나옴
        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) > root) { // 루트보다 큰 값이면 오른쪽 서브트리에 포함
                leftSubTree = arr.subList(1, i);
                rightSubTree = arr.subList(i, arr.size());
                flag = true;
                break;
            }
        }

        // 모든 값이 왼쪽 서브트리일 경우
        if(!flag) {
            leftSubTree = arr.subList(1, arr.size());
        }

        // 후위 순위 처리
        solution(leftSubTree);
        solution(rightSubTree);
        System.out.println(root);
    }
}