import java.io.*;

public class Main {
    public static char[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str = br.readLine()) != null){
            int N = Integer.parseInt(str);
            int length = (int) Math.pow(3, N);
            array = new char[length];

            for(int i = 0; i < length; i++){
                array[i] = '-';
            }

            recursion(0, length);

            for(int j = 0; j < length; j++){
                bw.write(array[j]);
            }
            bw.write("\n");
            bw.flush();
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static void recursion(int start, int end){
        if(end < 3){
            return;
        }
        int blankStart = (end/3)+start;
        int blankEnd = blankStart + (end/3);
        for(int i = blankStart; i < blankEnd; i++){
            array[i] = ' ';
        }
        recursion(start, end/3);
        recursion(blankEnd, end/3);
    }
}