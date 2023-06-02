import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);
            int n = (int) chr;
            array.add(n);
        }
        int start = "a".charAt(0);
        int end = "z".charAt(0);
        for(int i = start; i <= end; i++){
            if(array.contains(i)){
                System.out.print(array.indexOf(i)+" ");
            } else {
                System.out.print(-1+" ");
            }
        }
    }
}