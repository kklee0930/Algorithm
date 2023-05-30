import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0; i < N; i++){
            int n = sc.nextInt();
            if(n<X){
                array.add(n);
            }
        }
        for(int number:array){
            System.out.print(number+" ");
        }
    }
}
