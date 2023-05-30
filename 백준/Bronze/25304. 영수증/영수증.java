import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int iter = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < iter; i++){
            int cost = sc.nextInt();
            int amount = sc.nextInt();
            sum += cost * amount;
        }
        if(sum==total){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }

}