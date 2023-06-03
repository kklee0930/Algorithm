import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String str = sc.nextLine();
        String s;
        for(int i = 0; i < str.length(); i++){
            s = String.valueOf(str.charAt(i)).toLowerCase();
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int maxValue = Collections.max(map.values());
        int cnt = 0;
        String maxKey = null;
        boolean flag = true;
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() == maxValue){
                maxKey = entry.getKey();
                cnt++;
                if(cnt > 1){
                    System.out.println("?");
                    flag = false;
                    break;
                }
            }
        }
        if(flag == true){
            System.out.println(maxKey.toUpperCase());
        }
    }
}