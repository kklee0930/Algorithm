import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        // input이 없을 때까지 계속 받기
        while((input = br.readLine()) != null) {
            
            char[] a = input.toCharArray();
            char[] b = br.readLine().toCharArray();
            Map<Character, Integer> hashA = new TreeMap<>();
            Map<Character, Integer> hashB = new TreeMap<>();
            
            for(char chr : a) {
                hashA.put(chr, hashA.getOrDefault(chr, 0) + 1);
            }
            for(char chr : b) {
                hashB.put(chr, hashB.getOrDefault(chr, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            
            for(char key : hashA.keySet()) {
                if(hashB.keySet().contains(key)) {
                    int cnt = Math.min(hashA.get(key), hashB.get(key));

                    for(int i = 0; i < cnt; i++) {
                        sb.append(key);
                    }
                }
            }
            System.out.println(sb);
        }
        br.close();
    }
}