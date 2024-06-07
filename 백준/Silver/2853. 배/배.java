import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[5001];
        int count = 0;
        int answer = 0;
        boolean[] visited = new boolean[5001];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], i); // 배가 들어온 날, 인덱스 i
        }

        br.close();

        for(int i = 1; i < N; i++) {
            int curr = arr[i]; // 배가 들어온 날
            if(visited[i]) {
                continue;
            }
            
            int diff = curr - 1; // 배가 들어온 날 - 1일(첫날) = 배의 항구 방문 간격
            answer++;
            
            for(int j = curr; j <= arr[N - 1]; j += diff) { // 등차수열(배가 도착한 날짜)
                int index = map.get(j); // 날짜에 해당하는 인덱스

                if(!visited[index]) {
                    visited[index] = true;
                    count++;
                }
            }

            if(count == N - 1) {
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}