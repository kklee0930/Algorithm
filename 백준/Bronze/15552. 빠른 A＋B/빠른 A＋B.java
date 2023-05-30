import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
//        BufferedReader와 BufferedWriter는 Scanner와 println과 유사하다. 공백을 기준으로 문자를 구분하여 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine()); // 문자를 모두 String 형태로 받기 때문에 형변환이 필수이다.
        for(int i = 0; i < tc; i++){
            StringTokenizer s = new StringTokenizer(br.readLine()); // Tokenizer를 활용해서 input을 받는다.
            bw.write((Integer.parseInt(s.nextToken()))+Integer.parseInt(s.nextToken())+"\n");
        }
        bw.close();
    }

}