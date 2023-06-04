import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;
        String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] scores = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
        double totalGPA = 0;
        double pointCnt = 0;
        double gradePoint = 0;
        int length = grades.length;
        while((str = br.readLine()) != null && !str.isEmpty()){
            st = new StringTokenizer(str);
            String className = st.nextToken();
            double gradeWeight = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(grade.equals("P")){
                continue;
            }
            for(int i = 0; i < length; i++){
                if(grades[i].equals(grade)){
                    gradePoint = scores[i];
                    break;
                }
            }
            totalGPA += gradePoint * gradeWeight;
            pointCnt += gradeWeight;
        }
        String answer = String.format("%.6f", totalGPA/pointCnt);
        bw.write(answer);
        br.close();
        bw.flush();
        bw.close();
    }
}