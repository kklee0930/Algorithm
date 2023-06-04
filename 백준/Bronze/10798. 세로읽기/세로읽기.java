import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String[] array = new String[5];
        int maxLength = -1;
        for(int i = 0; i < 5; i++){
            String str = sc.nextLine();
            int length = str.length();
            if(length > maxLength){
                maxLength = length;
            }
            array[i] = str;
        }
        for(int i = 0; i < maxLength; i++){
            for(int j = 0; j < 5; j++){
                try{
                    sb.append(array[j].charAt(i));
                } catch(StringIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
        System.out.println(sb);
    }
}