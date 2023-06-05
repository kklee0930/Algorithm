import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 2;
        for(int i = 0; i < num; i++){ // 1: 4, 2: 9, 3: 25, 4: 81 (2제곱, 3제곱, 5제곱, 9제곱)
            answer += (int)(Math.pow(2, i));
        }
        System.out.println((int)(Math.pow(answer, 2)));
    }
}