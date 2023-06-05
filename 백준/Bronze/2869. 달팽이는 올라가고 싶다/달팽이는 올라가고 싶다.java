import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken())-down;
        int dayCnt;
        int n = up - down;
        if(goal % n == 0){
            dayCnt = goal / n;
        } else {
            dayCnt = goal / n + 1;
        }
        bw.write(Integer.toString(dayCnt));
        br.close();
        bw.flush();
        bw.close();
    }
}