import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> absent = new ArrayList<Integer>();
        for(int i = 0; i < 28; i++){
            array.add(sc.nextInt());
        }
        int cnt = 1;
        while(absent.toArray().length < 2){
            if(!array.contains(cnt)){
                absent.add(cnt);
            }
            cnt++;
        }
        Collections.sort(absent);
        for(int num:absent){
            System.out.println(num);
        }
    }
}