import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int currNum = 1;
        boolean impossible = false;
        stack.push(0);

        for(int i = 0; i < n; i++){
            num = sc.nextInt();

            if(stack.peek() < num){ // peek가 더 작을경우 push를 해야함
                if(currNum > num){ // currNum은 계속해서 증가하기 때문에 num보다 큰 상태라면 num을 pop하기가 불가능
                    impossible = true;
                    break;
                }

                while(currNum <= num){
                    stack.push(currNum++);
                    sb.append("+").append("\n");
//                    System.out.println(stack);
                }
                stack.pop();
                sb.append("-").append("\n");
//                System.out.println(stack);
            }

            else if(stack.peek() > num){ // peek가 더 클 경우 pop 해야함
                while(stack.peek() > num){
                    stack.pop();
                    sb.append("-").append("\n");
//                    System.out.println(stack);
                }
            }

            else if(stack.peek() == num){ // 같으면 pop
                stack.pop();
                sb.append("-").append("\n");
//                System.out.println(stack);
            }
        }

        sc.close();

        if(impossible){
            System.out.println("NO");
        }
        else {
            System.out.println(sb);
        }
    }
}