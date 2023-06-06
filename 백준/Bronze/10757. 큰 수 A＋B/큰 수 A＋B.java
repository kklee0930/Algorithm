import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken(); String B = st.nextToken();

        int lengthA = A.length(); int lengthB = B.length();
        int maxLength = Math.max(lengthA, lengthB);

        int[] arrayA = new int[maxLength + 1]; // 마지막 숫자에서 자릿수 올림이 발생할 수 있기 때문에 maxLength + 1
        int[] arrayB = new int[maxLength + 1];

        for(int i = lengthA-1, idx = 0; i >= 0; i --, idx++){
            arrayA[idx] = A.charAt(i) - '0'; // 작은 자릿수부터 array에 idx순서대로 삽입
        }
        for(int i = lengthB-1, idx = 0; i >= 0; i --, idx++){
            arrayB[idx] = B.charAt(i) - '0';
        }

        for(int i = 0; i < maxLength; i++){
            int sum = arrayA[i] + arrayB[i];
            arrayA[i] = sum % 10; // 나머지 = 현재 자릿수 값, 몫 = 자릿수 올림 값
            arrayA[i+1] += sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        if(arrayA[maxLength] != 0){
            sb.append(arrayA[maxLength]);
        }
        for(int i = maxLength-1; i >= 0 ; i--){
            sb.append(arrayA[i]);
        }
        System.out.println(sb);
    }
}