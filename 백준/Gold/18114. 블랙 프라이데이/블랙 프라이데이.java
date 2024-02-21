import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int C;
    static int[] arr;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물건의 갯수
        C = Integer.parseInt(st.nextToken()); // 물건 무게 제한

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        set = new HashSet<>();

        br.close();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 1개 골라서 무게를 맞추는 경우
            if(num == C) {
                bw.write(1 + "");
                bw.flush();
                bw.close();
                return;
            }
            set.add(num);
            arr[i] = num;
        }

        Arrays.sort(arr);

        // 2개 골라서 무게를 맞추는 경우
        for(int i = 0; i < N; i++) {
            int num = C - arr[i];

            // 중복된 무게를 고를 수 없으므로
            if(num == arr[i]) {
                continue;
            }
            if(set.contains(num)) {
                bw.write(1 + "");
                bw.flush();
                bw.close();
                return;
            }
        }

        // 3개 골라서 무게를 맞추는 경우
        if(pickThree()) {
            bw.write(1 + "");
        }
        // 만족하는 조합 존재하지 않는 경우
        else {
            bw.write(0 + "");
        }
        bw.flush();
        bw.close();
    }

    // 3개 골라서 무게를 맞추는 경우
    static boolean pickThree() {

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                
                // (목표 무게 - 선택한 무게의 합) 값이 set에 존재하면 경우의 수 존재함
                int num = C - arr[i] - arr[j];

                // 중복된 무게를 고를 수 없으므로
                if(num == arr[i] || num == arr[j]) {
                    continue;
                }
                if(set.contains(num)) {
                    return true;
                }
                // 갈수록 C - arr[i] - arr[j]는 작아지기 때문에 음수가 나오면 return
                else if(num < 0) {
                    return false;
                }
            }
        }
        return false;
    }
}