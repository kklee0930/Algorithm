import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        while((str = br.readLine()) != null && !str.isEmpty()){
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int num = Integer.parseInt(st.nextToken());
            for(int i = start; i <= end; i++){
                array[i] = num;
            }
        }
        for(int number:array){
            System.out.print(number+" ");
        }
    }
}
