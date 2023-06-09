import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        br.close();

        boolean flag = false;
        int num;

        for(int i = 0; i < N-1; i++){
            num = i;
            String numStr = Integer.toString(num);
            for(char number: numStr.toCharArray()){
                num += Character.getNumericValue(number);
            }
            if(num == N){
                bw.write(Integer.toString(i));
                flag = true;
                break;
            }
        }
        if(!flag){
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }
}