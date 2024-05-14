import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int maxRange = 10000000; // 최대 범위가 10^14이기 때문에 제곱근인 10^7을 범위로 설정

        long[] arr = new long[maxRange + 1];

        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        // 소수 아닌 수 걸러내기
        for(int i = 2; i <= Math.sqrt(arr.length); i++) {
            if(arr[i] == 0) {
                continue;
            }
            // 배수인 수들은 모두 소수가 아님
            for(int j = i + i; j < arr.length; j += i) {
                arr[j] = 0;
            }
        }

        // 범위 내의 거의 소수 판별하기
        int cnt = 0;
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] != 0) {
                long powered = arr[i];
                
                while((double)arr[i] <= (double)B / (double)powered) {
                    if((double)arr[i] >= (double)A / (double)powered) {
                        cnt++;
                    }
                    powered *= arr[i]; // 제곱처리
                }
            }
        }
        System.out.println(cnt);
    }
}