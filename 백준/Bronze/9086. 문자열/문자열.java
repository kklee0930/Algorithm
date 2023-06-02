import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        String str;
        for(int i = 0; i < tc; i++){
            str = sc.next();
            char chr = str.charAt(0);
            char chr2 = str.charAt(str.length()-1);
            sb.append(chr);
            sb.append(chr2);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}