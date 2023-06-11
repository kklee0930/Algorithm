import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int[][] array = new int[tc][2];

        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(array, (a,b) -> {
          if(a[0] != b[0]){
              return Integer.compare(a[0], b[0]);
          }
          return Integer.compare(a[1], b[1]);
        });

        StringBuilder sb = new StringBuilder();

        for(int[] arr: array){
            sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
        }

        System.out.println(sb);
    }
}