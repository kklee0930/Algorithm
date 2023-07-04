import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String user1, user2;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ChongChong", 1);
        int cnt = 1;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            user1 = st.nextToken();
            user2 = st.nextToken();

            if(map.containsKey(user1) || map.containsKey(user2)){
                if(!map.containsKey(user1)){
                    map.put(user1, 1);
                    cnt++;
                }
                if(!map.containsKey(user2)){
                    map.put(user2, 1);
                    cnt++;
                }
            }
        }

        br.close();

        System.out.println(cnt);
    }
}