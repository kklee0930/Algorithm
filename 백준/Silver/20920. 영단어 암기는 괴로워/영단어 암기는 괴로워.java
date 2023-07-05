import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>(); // 단어 등장 빈도를 저장하는 hashmap

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length() >= M){ // 길이가 M보다 큰 단어만 입력받는다
                map.put(word, map.getOrDefault(word, 0) + 1); // 등장 빈도를 hashmap에 저장한다
            }
        }

        br.close();

        List<String> array = getAnswer(map);
        StringBuilder sb = new StringBuilder();

        for(String word: array){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
    static List<String> getAnswer(HashMap<String, Integer> map){
        List<String> words = map.keySet().stream().collect(Collectors.toList());

        words.sort((o1, o2) -> {
            // 등장 빈도 수
            int value1 = map.get(o1);
            int value2 = map.get(o2);

            if(value1 == value2){ // 서로 빈도수가 같으면(조건1)
                if(o1.length() == o2.length()){ // 서로 단어의 길이가 같으면(조건2)
                    return o1.compareTo(o2); // 단어의 알파벳 순으로 비교(조건3)
                }
                return o2.length() - o1.length(); // 단어의 길이 순으로 비교(조건2)
            }
            return value2 - value1; // 단어의 등장 빈도로 순으로 비교(조건1)
        });

        return words;
    }
}