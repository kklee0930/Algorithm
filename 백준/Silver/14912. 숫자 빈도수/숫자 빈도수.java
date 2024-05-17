import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        char d = sc.next().charAt(0);
        sc.close();
        
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            cnt += num.chars().filter(chr -> chr == d).count();
        }
        System.out.println(cnt);
    }
}