import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 1; i < N + 1; i++){
            if(N % i == 0){
                array.add(i);
            }
        }
        if(array.size() >= K){
            System.out.println(array.get(K-1));
        } else {
            System.out.println(0);
        }
    }
}