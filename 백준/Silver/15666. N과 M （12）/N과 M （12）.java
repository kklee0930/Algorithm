import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] sortedArr;
    static int m;
    static int n;
    static LinkedHashSet<String> hashSet = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sortedArr = new int[n];
        arr = new int[m];

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < n; i++) {
            sortedArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);

        dfs(0, 0);
        for(String num : hashSet) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int depth) {

        // depth 도달하면 출력
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            hashSet.add(sb.toString());
            return;
        }

        // depth 도달하지 않았을 경우 재귀
        for(int i = start; i < n; i++) {
            arr[depth] = sortedArr[i];
            dfs(i, depth+1);
        }
    }
}