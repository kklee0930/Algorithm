import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); int y = sc.nextInt();
        int w = sc.nextInt(); int h = sc.nextInt();
        int xDiff = Math.abs(x-w); int yDiff = Math.abs(y-h);
        System.out.println(Math.min(Math.min(x, y), Math.min(xDiff, yDiff)));
    }
}