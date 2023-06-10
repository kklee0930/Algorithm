import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int multiplier = N / 5; // 봉지를 가장 적게 가지게 하기 위해서 무게에 5를 나눈 값에서 1씩 줄여나간다.
        int remains; // 무게 N에서 5kg 봉투의 무게를 뺀 나머지 무게
        int bagCnt = 0; // 설탕봉지 갯수

        boolean flag = false;

        while(multiplier >= 0){
            bagCnt = multiplier;
            remains = N - (5*multiplier);
            if(remains % 3 == 0){
                bagCnt += (remains / 3);
                flag = true;
                break;
            }
            multiplier--;
        }
        if(flag){
            System.out.println(bagCnt);
        }
        else if(!flag && N % 3 == 0){
            bagCnt = N / 3;
        }
        else{
            System.out.println(-1);
        }
    }
}