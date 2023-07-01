import java.util.*;

public class Main {
    public static int[] arr, temp;
    public static int cnt;
    public static int K;
    public static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(); // 배열크기
        K = sc.nextInt(); // 저장횟수

        arr = new int[A];
        temp = new int[A];

        for(int i = 0; i < A; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        mergeSort(arr, 0, A-1);
        System.out.println(result);

    }

    public static void mergeSort(int[] arr, int p, int r){ // 배열을 오름차순 정렬
        if(p < r){
            int q = (p + r) / 2; // 중간지점
            mergeSort(arr, p, q); // 전반부 정렬
            mergeSort(arr, q+1, r); // 후반부 정렬
            merge(arr, p, q, r); // 병합
        }

        if(cnt > K){
            return;
        }
    }

    public static void merge(int[] arr, int p, int q, int r){ // 배열 병합
        int i = p;
        int j = q+1;
        int t = 0;

        while(i <= q && j <= r){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
            }
            else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        while(i <= q){
            temp[t++] = arr[i++];
        }
        while(j <= r){
            temp[t++] = arr[j++];
        }

        i = p;
        t = 0;
        while(i <= r){
            cnt++;
            if(cnt == K){
                result = temp[t];
                break;
            }
            arr[i++] = temp[t++];
        }
    }
}