import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        String str;

        for(int i = 0; i < T; i++){
            stack.clear();
            str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                char chr = str.charAt(j); // 받아온 문자열을 하나하나 iteration

                if(chr == '('){ // 여는 괄호는 VPS조합을 완성시킬 수 없으므로 stack에 push
                    stack.push(chr);
                }
                else { // 닫는 괄호
                    if(stack.empty()){ // stack이 비었는데 닫는괄호가 들어오면 not VPS
                        stack.push(chr);
                        break;
                    }
                    else if(stack.peek() == '('){ // VPS
                        stack.pop();
                    }
                }
            }

            if(stack.empty()){
                sb.append("YES");
            }
            else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        br.close();
        System.out.println(sb);
    }
}