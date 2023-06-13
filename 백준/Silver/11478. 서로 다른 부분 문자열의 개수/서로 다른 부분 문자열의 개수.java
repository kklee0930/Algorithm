import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();

        int length = str.length();
        int cnt = 0;
        while (cnt <= length){
            for(int i = 0; i < length; i++){
                try {
                    set.add(str.substring(i, i+cnt+1));
                }
                catch (Exception e) {
                    break;
                }
            }
            cnt++;
        }
        System.out.println(set.size());
    }
}