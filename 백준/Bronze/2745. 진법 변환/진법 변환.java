import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next(); int B = sc.nextInt();
        int length = N.length();
        int sum = 0;
        for(int i = 0; i < length; i++){
            char c = N.charAt(i);
            int num = c - '0'; // char를 int로 변환
            if(c > 64 && c < 91){ // c가 A~Z사이의 알파벳이면 그에 맞게 변환
                num -= 7;
            }
            sum += num*(Math.pow(B, length-1-i));
        }
        System.out.println(sum);
    }
}