import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 인원 수
        int C = Integer.parseInt(st.nextToken()); // 그룹 수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        br.close();

        // 원생의 키 오름차순으로 배열에 저장
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 인접한 원생 간 키 차이 배열
        ArrayList<Integer> heightGap = new ArrayList<>();
        for(int i = 1; i < N; i++) {
            heightGap.add(arr[i] - arr[i - 1]);
        }

        // 원생 간 키 오름차순 정렬
        Collections.sort(heightGap);

        int sum = 0;
        // N - C번 그룹 합치기를 하면 총 비용의 최솟값
        for(int i = 0; i < N - C; i++) {
            sum += heightGap.get(i);
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}