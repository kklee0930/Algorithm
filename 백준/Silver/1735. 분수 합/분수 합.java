import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt(), a2 = sc.nextInt();
        int b1 = sc.nextInt(), b2 = sc.nextInt();
        sc.close();

        int gcd = getGCD(a2, b2); // 최대공약수
        int lcm = a2 * b2 / gcd; // 최소공배수 = a * b / a, b의 최대공약수
        int numerator = (a1 * (lcm / a2)) + (b1 * (lcm / b2));

        // 기약분수를 만들기 위해서 한번더 최대공약수 구하기.
        int gcd2 = getGCD(numerator, lcm);

        System.out.println(numerator/gcd2 + " " + lcm/gcd2);
    }

    public static int getGCD(int n1, int n2){ // 유클리드 호제법
        int r;
        while(n2 != 0){
            r = n1 % n2;

            n1 = n2;
            n2 = r;
        }
        return n1;
    }
}