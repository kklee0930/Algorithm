import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        String name;
        // 듣도 못한 사람
        for(int i = 0; i < N; i++){
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 보도 못한 사람
        for(int i = 0; i < M; i++){
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> array = new ArrayList<String>();

        // 2회 이상 언급된 인물이 듣도보도 못한 인물. array에 추가
        for(String n: map.keySet()){
            if(map.get(n) >= 2){
                array.add(n);
            }
        }

        Collections.sort(array);

        System.out.println(array.size());
        for(String str: array){
            System.out.println(str);
        }
    }
}