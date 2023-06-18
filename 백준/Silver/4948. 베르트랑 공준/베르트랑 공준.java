import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        StringBuilder sb = new StringBuilder();
        int cnt;

        while((n = sc.nextInt()) != 0){
            cnt = 0;
            for(int i = n+1; i <= 2*n; i++){
                if(isPrime(i)){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        sc.close();
        System.out.println(sb);
    }

    public static boolean isPrime(int a){
        if(a == 1){
            return false;
        }
        for(int i = 2; i * i <= a; i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
}