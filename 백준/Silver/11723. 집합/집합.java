import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = 0;
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("all")) { // 20까지 생성
                S = (1 << 21) - 1;
            }
            else if(cmd.equals("empty")) {
                S = 0;
            }
            else {
                int num = Integer.parseInt(st.nextToken());
                if(cmd.equals("add")) {
                    S = S | (1 << num);
                }
                else if(cmd.equals("remove")) {
                    S = S & ~(1 << num);
                }
                else if(cmd.equals("check")) {
                    sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                }
                else if(cmd.equals("toggle")) {
                    S = S ^ (1 << num);
                }
            }
        }
        br.close();
        System.out.println(sb.toString());
    }
}