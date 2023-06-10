import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] array = new int[tc];
        for(int i = 0; i < tc; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for(int num: array){
            System.out.println(num);
        }
    }
}