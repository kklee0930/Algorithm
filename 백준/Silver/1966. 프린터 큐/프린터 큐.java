import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int N, M;
        LinkedList<int[]> queue;
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 문서의 갯수
            M = Integer.parseInt(st.nextToken()); // 몇번째로 인쇄되었는지 궁금한 문서의 queue index

            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();

            int cnt = 0; // 인쇄 횟수
            for(int j = 0; j < N; j++){ // queue에 {문서번호, 중요도} 추가
                queue.addLast(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            while(!queue.isEmpty()){

                int[] first = queue.removeFirst(); // 가장 앞에 있는 원소
                boolean isMax = true;

                for(int k = 0; k < queue.size(); k++){ // first가 최대 중요도값을 가지는지 체크를 위한 iteration

                    if(first[1] < queue.get(k)[1]){ // 가장 앞에 있는 first가 max가 아닐 경우
                        queue.addLast(first); // first와 k인덱스 이전의 원소들을 차례로 뒤로 보낸다.

                        for(int l = 0; l < k; l++){
                            queue.addLast(queue.removeFirst());
                        }

                        isMax = false;
                        break;
                    }
                }

                if(!isMax){ // 최대 중요도값을 가지지 않으면 다시 반복
                    continue;
                }

                // 최대 중요도 값을 지니는 것이었으면 cnt++
                cnt++;
                if(first[0] == M){ // 원하는 문서가 인쇄가 되면 break
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}