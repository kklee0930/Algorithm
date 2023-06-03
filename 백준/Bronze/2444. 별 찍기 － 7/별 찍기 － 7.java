import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int space = sc.nextInt();
        for(int i = 0; i < space; i++){
            for(int j = 0; j < space-1-i; j++){
                sb.append(" ");
            }
            sb.append("*");
            for(int k = 0; k < i*2; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = space-1; i > 0; i--){
            for(int j = 0; j < space-i; j++){
                sb.append(" ");
            }
            sb.append("*");
            for(int k = 0; k < (i-1) * 2; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}