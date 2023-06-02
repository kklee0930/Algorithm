import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int num;
        for(int i = 0; i < 10; i++){
            num = sc.nextInt() % 42;
            array.add(num);
        }
        Set<Integer> set = new HashSet<Integer>(array);
        System.out.println(set.size());
    }
}