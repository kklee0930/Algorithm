import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i < tc; i++){
            String str = sc.next();
            int length = str.length();
            char previous = 0;
            boolean[] array = new boolean[26];
            boolean flag = false;
            for(int j = 0; j < length; j++){
                char chr = str.charAt(j);
                if(chr != previous && array[chr-'a']){
                    flag = true;
                    break;
                }
                previous = chr;
                array[chr-'a'] = true;
            }
            if(!flag){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}