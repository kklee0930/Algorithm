import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();

        sc.close();

        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true; // 0과 1은 소수에서 제외

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) { // prime[i]가 소수라면
                for (int j = i * i; j <= N; j += i) { // 소수가 아닌 것을 true로 표시
                    prime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = M; i <= N; i++){
            if(!prime[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}