import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long cnt = 0;
        long number = n-1;
        for(int i = 1; i < n; i++){
            cnt += number;
            number--;
        }
        System.out.println(cnt);
        System.out.println(2);
    }
}