import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num;

        while((num = Integer.parseInt(br.readLine())) != -1){
            sb.append(num);
            int sum = 0;
            ArrayList<Integer> array = new ArrayList<Integer>();

            for(int i = 1; i < num; i++){
                if(num%i == 0){
                    sum += i;
                    array.add(i);
                }
            }

            if(sum == num){
                sb.append(" = ");

                for(int number: array){
                    sb.append(number + " + ");
                }

                sb = new StringBuilder(sb.substring(0, sb.length() - 3));
                sb.append("\n");
            }
            else {
                sb.append(" is NOT perfect."+"\n");
            }
        }
        System.out.println(sb);
    }
}