import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<int[]> arr = new ArrayList<>(); // 키와 몸무게 저장하기 위한 배열

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr.add(new int[]{weight, height});
        }
        br.close();
        
        for(int[] data : arr) {
            int rank = 1;
            for(int[] compareData : arr) {
                if(data[0] < compareData[0] && data[1] < compareData[1]) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }
        bw.flush();
        bw.close();
    }
}