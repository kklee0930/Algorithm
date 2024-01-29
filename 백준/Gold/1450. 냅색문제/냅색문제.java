import java.io.*;
import java.util.*;

public class Main {

    static int C;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int leftSize = N / 2;

        // left, right 그룹으로 나누기
        arr = new int[N];

        // 가짓수 저장하기 위한 배열
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        dfs(0, leftSize, 0, leftArr);
        dfs(leftSize + 1, N - 1, 0, rightArr);

        Collections.sort(leftArr);
        Collections.sort(rightArr);

        int result = 0;
        int rightIdx = rightArr.size() - 1;
        for(int leftIdx = 0; leftIdx < leftArr.size(); leftIdx++) {
            // rightIdx가 0보다 작거나 leftArr값 + rightArr값이 C보다 작아질때까지 rightArr-- 처리
            while(rightIdx >= 0 && leftArr.get(leftIdx) + rightArr.get(rightIdx) > C) {
                rightIdx--;
            }
            // C보다 작아져야 무게 초과 없이 배낭에 담을 수 있기 때문에
            result += rightIdx+1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int end, int sum, ArrayList<Integer> sumArr) {
        if(sum > C) { // 물건조합의 합이 최대 무게보다 커지면 return
            return;
        }
        if(start > end) { // 해당 그룹의 범위를 넘어가면 return
            sumArr.add(sum);
            return;
        }
        dfs(start + 1, end, sum, sumArr); // 물건을 배낭에 담는 경우
        dfs(start + 1, end, sum + arr[start], sumArr); // 물건을 배낭에 담지 않는 경우
    }
}