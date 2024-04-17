import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 인원 수
        int q = (int) Math.round(N * 0.15); // 제외할 15%의 인원 수
        
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        double sum = 0;
        
        for(int j = q; j < N - q; j++) {
            sum += arr[j];
        }
        System.out.println((int)Math.round(sum / (N - 2 * q)));
    }
}