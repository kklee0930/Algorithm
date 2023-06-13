import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)){
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}