import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 1;
        int sum = 1;
        while(num > sum){
            cnt++;
            sum += (cnt * 6 - 6);
        }
        System.out.println(cnt);
    }
}