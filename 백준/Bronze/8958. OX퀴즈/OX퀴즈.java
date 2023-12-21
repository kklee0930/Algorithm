import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String OX = br.readLine();

            int sum = 0;
            int consecutiveCnt = 0;
            for(int j = 0; j < OX.length(); j++) {
                if(OX.charAt(j) == 'O') {;
                    sum += ++consecutiveCnt;
                }
                else {
                    consecutiveCnt = 0;
                }
            }
            sb.append(sum).append("\n");
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
