import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[5];

        for(int i = 0; i < 5; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int sum = Arrays.stream(array).sum();
        int avg = sum / 5;
        int median = array[2];

        System.out.println(avg+"\n"+median);
    }
}