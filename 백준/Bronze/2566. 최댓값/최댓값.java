import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1;
        int a = 0; int b = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int num = sc.nextInt();
                if(num > max){
                    a = i+1; b = j+1;
                    max = num;
                }
            }
        }
        System.out.println(max);
        System.out.println(a+" "+b);
    }
}