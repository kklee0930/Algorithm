import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String StringB = Integer.toString(b);
        int cnt = 1;
        int answer = 0;
        for(int i=StringB.length()-1; i>=0; i--) {
            int num = StringB.charAt(i)-48;
            int n = cnt * num * a;
            answer += n;
            cnt *= 10;
            System.out.println(num*a);
        }
        System.out.println(answer);

    }

}