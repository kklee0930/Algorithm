import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        while(N != 1){
            boolean flag = false;
            for(int i = 2; i < N; i++){
                if(N%i == 0){
                    sb.append(i).append("\n");
                    N /= i;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        if(N == 1){
            System.out.println();
        } else {
            sb.append(N);
            System.out.println(sb);
        }
    }
}