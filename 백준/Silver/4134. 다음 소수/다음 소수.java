import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        long n;

        for(int i = 0; i < tc; i++){
            n = Long.parseLong(br.readLine());
            while(!isPrime(n)){
                n++;
            }
            sb.append(n).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    public static boolean isPrime(long number){
        if(number < 2){
            return false;
        }
        for(long i = 2; i * i <= number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}