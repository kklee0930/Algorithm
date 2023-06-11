import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

        br.close();

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for(int number: array){
            sb.append(number).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}