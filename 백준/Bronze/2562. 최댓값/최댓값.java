import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int[] array = new int[9];
        int max = -1;
        int idx = -1;
        int num;
        for(int i=0; i<9; i++){
            num = sc.nextInt();
            array[i] = num;
            if(num > max){
                max = num;
                idx = i+1;
            }
        }
        System.out.print(max+"\n"+idx);
    }
}
