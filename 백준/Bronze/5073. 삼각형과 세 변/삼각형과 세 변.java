import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0){
                break;
            }
            else {
                if(a+b <= c || a+c <= b || b+c <= a){
                    sb.append("Invalid").append("\n");
                }
                else if(a-b==0 && a-c==0){
                    sb.append("Equilateral").append("\n");
                }
                else if(a == b || b == c || a == c){
                    sb.append("Isosceles").append("\n");
                }
                else {
                    sb.append("Scalene").append("\n");
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}