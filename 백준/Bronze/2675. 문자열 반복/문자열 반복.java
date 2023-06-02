import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++){
                String chr = String.valueOf(str.charAt(j));
                for (int k = 0; k < iter; k++){
                    sb.append(chr);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
        bw.flush();
        bw.close();
    }
}