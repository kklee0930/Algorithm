import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = i+1;
        }
        String str;
        while((str = br.readLine())!= null && !str.isEmpty()){
            st = new StringTokenizer(str);
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int[] temp = new int[end-start+1];
            for(int i = end, j = 0; i > start - 1; i--, j++){
                temp[j] = array[i];
            }
            for(int i = start, j = 0; i < end + 1; i++, j++){
                array[i] = temp[j];
            }
        }
        for(int number: array){
            System.out.print(number+" ");
        }
        br.close();

    }
}
