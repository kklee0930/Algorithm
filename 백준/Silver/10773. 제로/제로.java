import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < K; i++){
            int num = sc.nextInt();
            if(num == 0){
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }
        sc.close();

        int sum = 0;
        while(!stack.empty()){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}