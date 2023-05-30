import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=1; i <= tc; i++){
            for(int j=1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}