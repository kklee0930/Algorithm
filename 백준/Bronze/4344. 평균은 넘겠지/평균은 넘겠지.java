import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double sum; // 하나의 테스트 케이스에서의 학생의 점수 총합
        double totalCnt; // 학생 수
        double score; // 학생의 개별 점수
        double average; // sum / totalCnt
        double overAverage; // 평균 이상의 학생 수
        double percentage; // 평균 이상의 학생 비율
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            sum = 0;
            st = new StringTokenizer(br.readLine());
            totalCnt = Integer.parseInt(st.nextToken());
            ArrayList<Double> array = new ArrayList<Double>();
            for(int j = 0; j < totalCnt; j++){
                score = Integer.parseInt(st.nextToken());
                array.add(score);
                sum += score;
            }
            average = sum / totalCnt;
            overAverage = 0;
            for(double num: array){
                if(num > average){
                    overAverage += 1;
                }
            }
            percentage = (overAverage/totalCnt*100);
            bw.write(String.format("%.3f", percentage)+"%"+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}