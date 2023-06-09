import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        br.close();

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0, num;

        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    if((num = array[i] + array[j] + array[k]) > max && num <= M){
                        max = num;
                    }
                }
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}