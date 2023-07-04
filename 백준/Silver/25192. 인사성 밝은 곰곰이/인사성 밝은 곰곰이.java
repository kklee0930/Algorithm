import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input;
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            input = br.readLine();
            if(input.equals("ENTER")){
                set = new HashSet<>();
            }
            else if(set.contains(input)){
                continue;
            }
            else if(!set.contains(input)){
                set.add(input);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}