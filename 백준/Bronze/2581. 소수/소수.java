import java.io.*;

public class Main {
    public static boolean[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); int N = Integer.parseInt(br.readLine());
        int minPrimeNum = 0; // 소수의 최솟값
        int sum = 0; // 소수의 합

        array =  new boolean[N+1];
        primeMethod();

        for(int i = M; i <= N; i++){
            if(!array[i]){
                sum += i;
                if(minPrimeNum == 0){
                    minPrimeNum = i;
                }
            }
        }

        if(sum == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(minPrimeNum);
        }
    }
    public static void primeMethod(){ // 에라토스테네스의 체
        array[0] = true;
        array[1] = true;

        for(int i = 2; i < Math.sqrt(array.length); i++){
            for(int j = i * i; j < array.length; j += i){
                array[j] = true;
            }
        }
    }
}