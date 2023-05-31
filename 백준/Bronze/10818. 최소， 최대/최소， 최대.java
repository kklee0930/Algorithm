import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int idx = 0;
        while(st.hasMoreTokens()){
            array[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        Arrays.sort(array);
        System.out.printf("%d %d", array[0], array[N-1]);
    }
}
