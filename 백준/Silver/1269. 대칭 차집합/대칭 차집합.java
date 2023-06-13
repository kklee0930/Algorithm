import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(st.nextToken()), bLength = Integer.parseInt(st.nextToken());

        // 각각 집합의 hashmap 생성
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();

        // A집합 hashmap
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < aLength; i++){
            int num = Integer.parseInt(st.nextToken());
            mapA.put(num, mapA.getOrDefault(mapA.get(num), 0) + 1);
        }

        // B집합 hashmap
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < bLength; i++){
            int num = Integer.parseInt(st.nextToken());
            mapB.put(num, mapB.getOrDefault(mapB.get(num), 0) + 1);
        }

        // B집합 - A집합
        int cnt = 0;
        HashMap<Integer, Integer> temp = new HashMap<>(mapB);
        for(int number: mapA.keySet()){
            try {
                temp.remove(number);
            }
            catch (NullPointerException e) {
            }
        }
        cnt += temp.size();
        
        // A집합 - B집합
        for(int number: mapB.keySet()){
            try {
                mapA.remove(number);
            }
            catch (NullPointerException e) {
            }
        }
        cnt += mapA.size();

        System.out.println(cnt);
    }
}