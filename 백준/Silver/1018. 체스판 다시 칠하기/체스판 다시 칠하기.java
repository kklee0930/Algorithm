import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] array;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        array = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < M; j++){
                if(str.charAt(j) == 'W'){ // 흰색이면 true, 검은색이면 false로 array에 삽입
                    array[i][j] = true;
                } else {
                    array[i][j] = false;
                }
            }

        }

        br.close();

        // 경우의수는 N-7, M-7 (예: 8*8은 1*1로 한가지이다.)
        int cntN = N - 7;
        int cntM = M - 7;

        for(int i = 0; i < cntN; i++){
            for(int j = 0; j < cntM; j++){
                check(i, j);
            }
        }
        System.out.println(min);
    }

    public static void check(int x, int y){
        int rowLimit = x + 8;
        int colLimit = y + 8;
        int cnt = 0;

        boolean checker = array[x][y]; // 시작하는 타일의 색깔 ('W' = true, 'B' = false)

        for(int i = x; i < rowLimit; i++){
            for(int j = y; j < colLimit; j++){

                if(array[i][j] != checker){ // 타일 색깔이 맞지 않으면 교체카운트++
                    cnt++;
                }

                checker = (!checker); // 다음 타일은 색깔이 바뀌므로 변경해주기

            }

            checker = (!checker); // 다음 타일은 색깔이 바뀌므로 변경해주기
        }

        cnt = Math.min(cnt, 64-cnt); // 시작색깔 기준 카운트와 아닌색깔 기준 카운트 중 더 작은 값을 cnt로 초기화
        min = Math.min(cnt, min);
    }
}