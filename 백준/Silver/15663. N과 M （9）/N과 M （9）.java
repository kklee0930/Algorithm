import java.io.*;
import java.util.*;

public class Main {

    static int m;
    static int n;
    static int[] arr;
    static int[] sortedNums;
    static LinkedHashSet<String> set;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 자연수 갯수
        m = Integer.parseInt(st.nextToken()); // 자연수 값(길이가 m인 수열 구하기)
        sortedNums = new int[n];
        arr = new int[m];
        visited = new boolean[n];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            sortedNums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        Arrays.sort(sortedNums);
        dfs(0);

        for (String permutation : set) {
            bw.write(permutation + "\n");
        }

        bw.flush();
        bw.close();
    }
    static void dfs(int depth) {

        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            set.add(String.valueOf(sb));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = sortedNums[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
}