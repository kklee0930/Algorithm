import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N]; // 정렬되지 않은 input 그대로의 array
        int[] sortedArray = new int[N]; // 정렬된 array

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;
            sortedArray[i] = n;
        }

        Arrays.sort(sortedArray);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(sortedArray[i])){
                map.put(sortedArray[i], cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num: array){
            sb.append(map.get(num)).append(" ");
        }

        System.out.println(sb);
    }
}