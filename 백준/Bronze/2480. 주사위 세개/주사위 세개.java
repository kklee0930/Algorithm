import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a==b && b==c){
            System.out.println(a*1000+10000);
        } else if(a==b || b==c || a==c){
            if(a==b){
                System.out.println(a*100+1000);
            } else if (b==c) {
                System.out.println(b*100+1000);
            } else {
                System.out.println(c*100+1000);
            }
        } else if(a!=b && b!=c && a!=c){ // 세 변수가 모두 다를 경우
            int max;
            if(a>b){ // a가 b보다 클 경우
                if(c>a){
                    max = c;
                } else{
                    max = a;
                }
            } else{ // b가 a보다 클 경우
                if(c>b){
                    max = c;
                } else{
                    max = b;
                }
            }
            System.out.println(max*100);
        }
    }

}