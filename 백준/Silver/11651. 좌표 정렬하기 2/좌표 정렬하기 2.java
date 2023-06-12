import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] array = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(array, (a,b) -> {
            if(a[1] != b[1]){ // y끼리 비교해서 같지 않으면 y기준으로 정렬
                return Integer.compare(a[1], b[1]);
            }
            else{
                return Integer.compare(a[0], b[0]); // x기준으로 정렬
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            sb.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}