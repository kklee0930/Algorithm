import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> array = new ArrayList<String>();

        String word;

        for(int i = 0; i < N; i++){
            word = br.readLine();
            if(!array.contains(word)){
                array.add(word);
            }
        }

        br.close();

        Collections.sort(array, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for(String str: array){
            System.out.println(str);
        }
    }
}