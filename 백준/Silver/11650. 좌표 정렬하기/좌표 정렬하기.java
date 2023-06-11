import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int[][] array = new int[tc][2];

        int[] tempArray;
        for(int i = 0; i < tc; i++){
            tempArray = new int[2];
            st = new StringTokenizer(br.readLine());
            tempArray[0] = Integer.parseInt(st.nextToken());
            tempArray[1] = Integer.parseInt(st.nextToken());
            array[i] = tempArray;
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
            sb.append(arr[0] + " " + arr[1] + "\n");
        }

        System.out.println(sb);
    }
}