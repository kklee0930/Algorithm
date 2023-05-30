import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> array = new ArrayList<Integer>();
        String len = br.readLine();
        st = new StringTokenizer(br.readLine());
        while(true){
            try{
                array.add(Integer.parseInt(st.nextToken()));
            } catch(NoSuchElementException e){
                break;
            }
        }
        int val = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int num: array){
            if(num==val){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
