import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<T; i++){
            int MIN = Integer.MAX_VALUE;
            int MAX = Integer.MIN_VALUE;
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num < MIN){
                    MIN = num;
                }
                if(num > MAX){
                    MAX = num;
                }
            }

            sb.append(MIN).append(" ").append(MAX).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}