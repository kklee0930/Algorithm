import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            array.add(sc.nextInt());
        }
        double max = Collections.max(array);
        double sum = 0;
        for(int i = 0; i < array.size(); i++){
            double n = array.get(i);
            sum += n/max*100;
        }
        System.out.println(sum / array.size());
    }
}