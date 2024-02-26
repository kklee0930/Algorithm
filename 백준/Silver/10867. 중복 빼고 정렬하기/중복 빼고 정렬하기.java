import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> arr = new ArrayList<>(hashSet);
        Collections.sort(arr);

        for(int num : arr) {
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
    }
}