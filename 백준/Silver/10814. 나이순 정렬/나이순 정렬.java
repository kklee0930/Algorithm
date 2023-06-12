import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        String[][] array = new String[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = st.nextToken();
            array[i][1] = st.nextToken();
        }

        br.close();
        
        Arrays.sort(array, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for(int i = 0; i < N; i++){
            System.out.println(array[i][0] + " " + array[i][1]);
        }
    }
}