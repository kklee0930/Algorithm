import java.util.*;

public class Main {
    public static char[][] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.close();

        array = new char[n][n];

        StringBuilder sb = new StringBuilder();

        recursion(0, 0, n, false);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(array[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void recursion(int x, int y, int n, boolean blank){
        if(blank){
            for(int i = x; i < x+n; i++){
                for(int j = y; j < y+n; j++){
                    array[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없을 때
        if(n == 1){
            array[x][y] = '*';
            return;
        }

        int size = n/3; // 블록 하나의 사이즈 (N = 27인 경우에는 9, N = 9인 경우에는 3)
        int cnt = 0; // 누적 별 합개
        for(int i = x; i < x+n; i += size){
            for(int j = y; j < y+n; j += size){
                cnt++;
                if(cnt == 5){ // 공백칸 (n=3 단위의 정사각형에서 [1][1]에서, 5번째에서 공백이 발생한다)
                    recursion(i, j, size, true);
                }
                else {
                    recursion(i, j, size, false);
                }
            }
        }
    }
}