import java.util.*;

public class Main {
    static int[] arr;
    static int cnt = 0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // index가 열, index의 정수가 행이다. 예: "0 index"의 "1"은 좌표 (1,0)과 동일하다.
        arr = new int[N]; // 퀸의 좌표가 담기는 배열

        nQueen(0); // 열 index 0부터 시작
        System.out.println(cnt);

    }

    public static void nQueen(int col){
        if(col == N){ // 마지막 열까지 공격할 수 없는 위치에 퀸들이 모두 채워지면 +1
            cnt++;
            return;
        }
        for(int row = 0; row < N; row++){
            arr[col] = row;
            if(isValid(col)){
                nQueen(col + 1);
            }
        }
    }

    public static boolean isValid(int col){
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]){ // 같은 행에 존재할 경우 불가능
                return false;
            }
            // 열의 차와 행의 차가 같으면 대각선에 존재하는 것이다.
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){ // 대각선에 존재하는지 체크
                return false;
            }
        }
        return true;
    }
}