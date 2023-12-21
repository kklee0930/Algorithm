import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());

            int roomWidth = order / height;
            int roomHeight = order % height;

            // 나머지가 0일 때
            if(roomHeight == 0) {
                sb.append(height * 100 + roomWidth).append("\n");
            }
            // 아닐 때
            else {
                sb.append((roomHeight * 100) + (roomWidth + 1)).append("\n");
            }
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
