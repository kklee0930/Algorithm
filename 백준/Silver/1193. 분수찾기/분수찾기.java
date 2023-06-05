import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 1;
        int sum = 1;
        while(num > sum){
            cnt ++;
            sum += cnt;
        }
        int idx = num - (sum - cnt);
        String denominator;
        String numerator;
        if(cnt % 2 == 0){ // 내림차순(분모)
            denominator = Integer.toString(cnt - idx + 1);
            numerator = Integer.toString(idx);
        } else { // 오름차순(분모)
            denominator = Integer.toString(idx);
            numerator = Integer.toString(cnt - idx + 1);
        }
        System.out.println(numerator+"/"+denominator);
    }
}