import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int result = 1;
        // A * B * C
        for(int i = 0; i < 3; i++) {
            result *= sc.nextInt();
        }
        // 결과 문자열화
        String temp = String.valueOf(result);

        // 0부터 1까지 몇번 쓰였는지 체크
        for(int i = 0; i < 10; i++) {
            int n = i;
            int numberCount = (int)temp.chars()
                    .filter(num -> Integer.parseInt(String.valueOf((char)num)) == n)
                    .count();
            System.out.println(numberCount);
        }
    }
}