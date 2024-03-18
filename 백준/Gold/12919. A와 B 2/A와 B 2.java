import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        bw.write(recursion(S, br.readLine()) + "");
        br.close();
        bw.flush();
        bw.close();
    }

    private static int recursion(String S, String T) {

        if(S.length() == T.length()) {
            if(S.equals(T)) {
                return 1;
            }
            return 0;
        }

        int temp = 0;
        // 문자열 S 뒤에 A를 추가한 경우
        if(T.charAt(T.length() - 1) == 'A') {
            temp += recursion(S, T.substring(0, T.length() - 1));
        }
        // 문자열 S에 B를 추가 후 뒤집은 경우
        if(T.charAt(0) == 'B') {
            T = new StringBuilder(T).reverse().substring(0, T.length() - 1);
            temp += recursion(S, T);
        }

        return temp > 0 ? 1 : 0;
    }
}