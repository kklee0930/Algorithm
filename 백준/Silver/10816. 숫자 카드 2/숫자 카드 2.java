import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine());

        // hashmap에 존재하지 않으면 value 1로 지정, 존재하면 value++
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!map.containsKey(num)){
                map.put(num, 1);
            }
            else {
                map.put(num, map.get(num) + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // hashmap에 존재하면 value 불러오기, 존재하지 않으면 0
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                sb.append(map.get(num)).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}