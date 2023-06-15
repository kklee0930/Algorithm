import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] trees = new int[N]; // 나무의 위치
        int[] dist = new int[N-1]; // 나무 사이의 간격
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(br.readLine());

            if(i > 0){
                dist[i-1] = trees[i] - trees[i-1];
            }
        }

        for(int i = 0; i < dist.length-1; i++){
            dist[i+1] = getGCD(dist[i], dist[i+1]);
        }
        int gcd = dist[dist.length-1];

        // trees[N-1] - trees[0] => 첫 가로수와 마지막 가로수 사이의 거리(전체거리)
        // gcd+1 => 가로수 "두개" 사이에 하나를 심는 것이기 때문에 gcd+1
        // trees.length => 이미 심어져 있는 가로수의 갯수
        System.out.println((trees[N-1] - trees[0]) / gcd + 1 - trees.length);
    }

    public static int getGCD(int a, int b){
        int r;
        while(b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}