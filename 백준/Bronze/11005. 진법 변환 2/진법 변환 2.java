import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int number = sc.nextInt();
        int div = sc.nextInt();
        int remain;
        while(number > 0){
            remain = number % div;
            number /= div;
            if(remain > 9){
                sb.append((char)(remain - 10 + 'A'));
            } else {
                sb.append((char)(remain + '0'));
            }
        }
        System.out.println(sb.reverse());
    }
}