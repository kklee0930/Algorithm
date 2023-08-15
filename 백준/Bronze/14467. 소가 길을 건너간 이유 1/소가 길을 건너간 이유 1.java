import java.util.*;

public class Main {
    static Integer[] cowStatus = new Integer[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        for(int i = 0; i < N; i++){
            int cowNum = sc.nextInt();
            int cowPosition = sc.nextInt();
            if(cowStatus[cowNum] == null){
                cowStatus[cowNum] = cowPosition;
            }
            else{
                if(!cowStatus[cowNum].equals(cowPosition)){
                    cnt++;
                    cowStatus[cowNum] = cowPosition;
                }
            }
        }

        System.out.println(cnt);
    }
}