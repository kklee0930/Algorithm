import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            if(n==0){
                br.close();
                bw.flush();
                bw.close();
                break;
            }else{
                bw.write(n+"\n");
            }
        }
    }
}
