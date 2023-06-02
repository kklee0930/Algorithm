import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next()).reverse();
        StringBuilder sb2 = new StringBuilder(sc.next()).reverse();
        int num1 = Integer.parseInt(sb.toString());
        int num2 = Integer.parseInt(sb2.toString());
        System.out.println(Math.max(num1, num2));
    }
}