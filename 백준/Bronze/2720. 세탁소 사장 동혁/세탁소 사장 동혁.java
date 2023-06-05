import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc  = Integer.parseInt(br.readLine());
        int[] array = {25, 10, 5, 1};
        for(int i = 0; i < tc; i++){
            int change = Integer.parseInt(br.readLine());
            for(int j = 0; j < 4; j++){
                sb.append((change/array[j])+" ");
                change %= array[j];
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}