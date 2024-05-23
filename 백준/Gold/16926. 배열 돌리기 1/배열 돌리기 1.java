import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 행
        int M = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 회전 수

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        // R번만큼 회전
        for(int i = 0; i < R; i++) {

            // 배열의 layer 갯수만큼 진행
            for(int j = 0; j < Math.min(N, M) / 2; j++) {
                
                int start = arr[j][j]; // 시작지점

                // 윗변의 숫자 회전 처리
                for(int k = j; k < M - j - 1; k++) {
                    arr[j][k] = arr[j][k + 1];
                }

                // 오른쪽 변의 숫자 회전 처리
                for(int k = j; k < N - j - 1; k++) {
                    arr[k][M - j - 1] = arr[k + 1][M - j - 1];
                }

                // 아래쪽 변의 숫자 회전 처리
                for(int k = M - j - 1; k > j; k--) {
                    arr[N - j - 1][k] = arr[N - j - 1][k - 1];
                }

                // 왼쪽 변의 숫자 회전 처리
                for(int k = N - j - 1; k > j; k--) {
                    arr[k][j] = arr[k - 1][j];
                }
                arr[j + 1][j] = start;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}