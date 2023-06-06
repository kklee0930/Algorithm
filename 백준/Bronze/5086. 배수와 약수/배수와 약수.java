import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a; int b;
        while((a = sc.nextInt()) != 0 && (b = sc.nextInt()) != 0){
            String answer = "neither";
            if(a > b){
                if(a%b == 0){
                    answer = "multiple";
                }
            } else if(a < b){
                if(b%a == 0){
                    answer = "factor";
                }
            }
            System.out.println(answer);
        }
    }
}