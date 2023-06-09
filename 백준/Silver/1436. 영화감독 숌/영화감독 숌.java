import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long cnt = 0;
        long number = 665;
        String str;

        while(cnt < N){
            number++;
            str = Long.toString(number);
            if(str.contains("666")){
                cnt++;
            }
        }

        System.out.println(number);
    }
}