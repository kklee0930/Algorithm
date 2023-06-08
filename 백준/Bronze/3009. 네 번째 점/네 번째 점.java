import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array1 = {sc.nextInt(), sc.nextInt()};
        int[] array2 = {sc.nextInt(), sc.nextInt()};
        int[] array3 = {sc.nextInt(), sc.nextInt()};

        sc.close();

        int x; int y;

        if(array1[0] == array2[0]){
            x = array3[0];
        }
        else if(array1[0] == array3[0]){
            x = array2[0];
        }
        else{
            x = array1[0];
        }

        if(array1[1] == array2[1]){
            y = array3[1];
        }
        else if(array1[1] == array3[1]){
            y = array2[1];
        }
        else{
            y = array1[1];
        }
        System.out.println(x+" "+y);
    }
}