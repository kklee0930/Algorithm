import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        boolean[][] array = new boolean[101][101];
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            for(int j = n; j < n+10; j++){
                for(int k = m; k < m+10; k++){
                    if(!array[j][k]){
                        array[j][k] = true;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}