import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String name;
        String status;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            status = st.nextToken();
            if(map.containsKey(name) && status.equals("leave")){ // 퇴근하는 경우
                map.remove(name);
            }
            else if (!map.containsKey(name) && status.equals("enter")){ // 출근하는 경우
                map.put(name, 1);
            }
        }

        br.close();

        String[] strArray = map.keySet().toArray(new String[map.size()]);

        Arrays.sort(strArray, Collections.reverseOrder());

        for(String active: strArray){
            System.out.println(active);
        }
    }
}