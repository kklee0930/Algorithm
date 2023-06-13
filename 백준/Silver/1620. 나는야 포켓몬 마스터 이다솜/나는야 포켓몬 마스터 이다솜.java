import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        
        String name;
        HashMap<String, Integer> stringMap = new HashMap<String, Integer>(); // K: 이름, V: 번호
        HashMap<Integer, String> integerMap = new HashMap<Integer, String>(); // V: 번호, K: 이름

        // hashmap에 이름과 번호 추가
        for(int i = 1; i <= N; i++){
            name = br.readLine();
            stringMap.put(name, i);
            integerMap.put(i, name);
        }

        // 문자를 입력받을 경우 번호 출력, 번호를 입력받을 경우 문자 출력
        for(int i = 0; i < M; i++){
            String input = br.readLine();
            if(stringMap.containsKey(input)){ // 문자로 주어질 때
                System.out.println(stringMap.get(input));
            }
            else { // 숫자로 주어질 때
                System.out.println(integerMap.get(Integer.parseInt(input)));
            }
        }

        br.close();
    }
}