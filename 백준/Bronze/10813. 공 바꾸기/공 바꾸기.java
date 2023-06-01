import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = i+1;
        }
        for(int i = 0; i < M; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int aNum = array[a];
            int bNum = array[b];
            array[a] = bNum;
            array[b] = aNum;
        }
        for(int number:array){
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }
}
