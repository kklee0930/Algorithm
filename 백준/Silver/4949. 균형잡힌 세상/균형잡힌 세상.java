import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str;
        String input;
        char chr;
        Stack<Character> stack = new Stack<>();

        while(!(input = br.readLine()).equals(".")){ // 온점이 나오면 종료
            st = new StringTokenizer(input);
            stack.clear(); // 매 문장마다 스택 비우기

            Boolean balanced = true;
            while(st.hasMoreTokens() && balanced){ // 다음 토큰이 없을 때까지
                str = st.nextToken();
                for(int i = 0; i < str.length(); i++){ // 문자열 iteration
                    chr = str.charAt(i);

                    if(chr == '(' || chr == '['){
                        stack.push(chr);
                    }
                    else if(chr == ')'){
                        if(stack.empty() || stack.peek() != '('){
                            stack.push(chr);
                            balanced = false;
                            break;
                        }
                        else {
                            stack.pop();
                        }
                    }
                    else if(chr == ']'){
                        if(stack.empty() || stack.peek() != '['){
                            stack.push(chr);
                            balanced = false;
                            break;
                        }
                        else {
                            stack.pop();
                        }
                    }

                }
            }

            if(stack.empty()){
                sb.append("yes");
            }
            else {
                sb.append("no");
            }
            sb.append("\n");
        }

        br.close();
        System.out.println(sb);
    }
}