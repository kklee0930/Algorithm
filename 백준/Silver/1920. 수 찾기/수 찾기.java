import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            map.put(sc.nextInt(), true);
        }

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            boolean exists = map.getOrDefault(sc.nextInt(), false);
            if(exists) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}