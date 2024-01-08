import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int diagonal = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        double temp = (double) Math.pow(diagonal, 2) / (Math.pow(height, 2) + Math.pow(width, 2));
        double tempSqrt = Math.sqrt(temp);
        bw.write((int)Math.floor(tempSqrt * height) + " " + (int)Math.floor(tempSqrt * width));
        bw.flush();
        bw.close();
    }
}