import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        ArrayList<Integer> xArray = new ArrayList<Integer>();
        ArrayList<Integer> yArray = new ArrayList<Integer>();

        for(int i = 0; i < tc; i++){
            xArray.add(sc.nextInt());
            yArray.add(sc.nextInt());
        }
        int maxX = Collections.max(xArray); int minX = Collections.min(xArray);
        int maxY = Collections.max(yArray); int minY = Collections.min(yArray);
        System.out.println((maxX-minX)*(maxY-minY));
    }
}