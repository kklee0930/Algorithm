import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        int cnt = 0;

        for(int i = 0; i < tc; i++){
            int num = sc.nextInt();
            if(num == 1){ // 1은 소수가 아님
                continue;
            }
            else if(num == 2){
                cnt++;
            }
            else {
                boolean flag = true;
                for(int j = 2; j < num-1; j++){
                    if(num % j == 0){
                        flag = false;
                        break;
                    }
                }

                if(flag == true){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}