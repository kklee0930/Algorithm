import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        if(m+t > 59){
            h += (m + t) / 60;
            h = h % 24;
            m = (m + t) % 60;
        } else {
            m += t;
        }
        System.out.println(h+" "+m);
    }

}