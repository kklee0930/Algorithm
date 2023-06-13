import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < N; i++){
            map.put(br.readLine(), 1);
        }

        int cnt = 0;

        for(int i = 0; i < M; i++){
            if(map.containsKey(br.readLine())){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}