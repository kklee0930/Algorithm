import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> hashMap = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();
            hashMap.put(address, password);
        }

        for(int j = 0; j < M; j++) {
            bw.write(hashMap.get(br.readLine()) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}