import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] chess = {1, 1, 2, 2, 2, 8};
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < chess.length; i++){
            int n = sc.nextInt();
            array.add(chess[i] - n);
        }
        for(int num: array){
            System.out.print(num+" ");
        }
    }
}