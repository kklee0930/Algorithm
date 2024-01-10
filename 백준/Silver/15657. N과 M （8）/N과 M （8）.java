import java.io.*;
import java.util.*;

public class Main {

    static int m;
    static int n;
    static int[] arr;
    static int[] sortedNums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 자연수 갯수
        m = Integer.parseInt(st.nextToken()); // 자연수 값(길이가 m인 수열 구하기)
        sortedNums = new int[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sortedNums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        Arrays.sort(sortedNums);
        dfs(0, 0);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    static void dfs(int start, int cnt) {

        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++) {
            arr[cnt] = sortedNums[i]; // i번째 숫자 선택
            dfs(i, cnt+1); // i+1번째 숫자 선택(재귀)
        }
    }
}