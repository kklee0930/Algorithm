import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int cnt = 0;
        for(int i = 0; i < length; i++){
            char chr = str.charAt(i);
            if(chr == 'c'){
                if(i < length - 1 && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')){
                    i++;
                }
            }
            else if(chr == 'd'){
                if(i < length - 1 && str.charAt(i+1) == '-'){
                    i++;
                }
                else if(i < length - 2 && str.charAt(i+1) == 'z'){
                    if(str.charAt(i+2) == '='){
                        i += 2;
                    }
                }
            }
            else if(i < length - 1 && (chr == 'l' || chr == 'n')){
                if(str.charAt(i+1) == 'j'){
                    i++;
                }
            }
            else if(i < length - 1 && (chr == 's' || chr == 'z')){
                if(str.charAt(i+1) == '='){
                    i++;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}