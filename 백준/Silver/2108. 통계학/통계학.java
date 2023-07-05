import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int max = -4000;
        int min = 4000;
        double sum = 0;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > max){ // 최댓값
                max = num;
            }
            if(num < min){ // 최솟값
                min = num;
            }
            arr.add(num); // 중앙값 구하기 위해서 array에 추가
            map.put(num, map.getOrDefault(num, 0) + 1); // 최빈값 구하기 위해서 map에 추가
            sum += num; // 산술평균 위한 합 구하기
        }

        br.close();

        // 산술평균 구하기
        double avg = sum / N;
        int Average = (int) Math.round(avg);
        sb.append(Average).append("\n");

        // 중앙값 구하기
        Collections.sort(arr);
        int Median = arr.get(N/2);
        sb.append(Median).append("\n");

        // 최빈값 구하기
        int maxVal = 0;
        for(int n: map.values()){
            maxVal = Math.max(n, maxVal);
        }
        arr.clear();

        for(int k: map.keySet()){
            if(map.get(k) == maxVal){
                arr.add(k);
            }
        }
        Collections.sort(arr);

        int Mode;
        if(arr.size() > 1){
            Mode = arr.get(1);
        }
        else {
            Mode = arr.get(0);
        }
        sb.append(Mode).append("\n");

        // 범위구하기
        int Range = max - min;
        sb.append(Range);

        System.out.println(sb);
    }
}