import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        int[] array = new int[tc];

        for(int i = 0; i < tc; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int num: array){
            sb.append(num + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}