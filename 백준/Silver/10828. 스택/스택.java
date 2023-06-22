import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            String str = sc.next();

            switch (str) {
                case "push":
                    stack.push(sc.nextInt());
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.pop());
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peek());
                    }
                    sb.append("\n");
                    break;
            }
        }
        sc.close();
        System.out.println(sb);
    }
}