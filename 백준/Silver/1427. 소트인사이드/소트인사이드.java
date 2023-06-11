import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strNum = br.readLine();
        int length = strNum.length();

        int[] array = new int[length];

        for(int i = 0; i < length; i++){
            array[i] = strNum.charAt(i) - '0';
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for(int i = length-1; i >= 0; i--){
            sb.append(array[i]);
        }

        System.out.println(sb);
    }
}