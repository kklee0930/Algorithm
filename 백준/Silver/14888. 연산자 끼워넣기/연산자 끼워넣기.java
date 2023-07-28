import java.util.*;
import java.io.*;

public class Main {
    static int[] numbers;
    static int N;
    static int[] operators = new int[4];
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(Max);
        System.out.println(Min);

    }
    static void dfs(int idx, int num){
        if(idx == N){ // 인덱스 끝까지 도달하면 모든 연산자 수행완료. 종료됨.
            Max = Math.max(Max, num);
            Min = Math.min(Min, num);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){ // 해당 연산자가 0보다 크면 -1
                operators[i]--;

                switch (i){ // 덧셈, 뺄셈, 곱셈, 나눗셈인지 판별 후에 계산한 값을 parameter 설정 후 재귀
                    case 0: dfs(idx+1, num+numbers[idx]); break;
                    case 1: dfs(idx+1, num-numbers[idx]); break;
                    case 2: dfs(idx+1, num*numbers[idx]); break;
                    case 3: dfs(idx+1, num/numbers[idx]); break;
                }

                operators[i]++; // 재귀 종료 시 연산자 값 복구
            }
        }
    }
}