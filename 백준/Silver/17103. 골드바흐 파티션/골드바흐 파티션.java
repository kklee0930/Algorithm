import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        int num; // input 값
        int cnt; // 각 테스트 케이스의 골드바흐 파티션의 수

        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true;

        // 미리 최대범위까지 에라토스테네스의 체 실행
        for (int i = 2; i * i <= 1000000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    prime[j] = true;
                }
            }
        }

        for(int i = 0; i < T; i++){
            cnt = 0;
            num = Integer.parseInt(br.readLine());

            for(int j = 2; j <= num/2; j++){ // 절반을 넘어가는 순간 쌍의 중복이 발생하므로 범위는 절반까지.
                if(!prime[j] && !prime[num-j]){
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}