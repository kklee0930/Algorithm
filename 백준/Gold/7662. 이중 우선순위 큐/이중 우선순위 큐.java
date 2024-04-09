import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // TC 갯수

        for(int i = 0; i < T; i++) {
            // TreeMap을 사용해서 Key를 자동 정렬
            // TreeMap<정수, 저장횟수>
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for(int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // 저장
                if(cmd.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }
                // 삭제
                else {
                    if(treeMap.isEmpty()) {
                        continue;
                    }
                    // 1이면 최댓값 삭제, 아니면 최솟값 삭제
                    int removal = num == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    if(treeMap.get(removal) == 1) {
                        treeMap.remove(removal);
                    }
                    else {
                        treeMap.put(removal, treeMap.get(removal) - 1);
                    }
                }
            }
            bw.write(treeMap.isEmpty() ? "EMPTY\n" : treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}