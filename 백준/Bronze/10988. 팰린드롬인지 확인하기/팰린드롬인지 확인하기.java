import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append(sc.nextLine());
        String reversed;
        if(sb.toString().equals(reversed = sb.reverse().toString())){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}