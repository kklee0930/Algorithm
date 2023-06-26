import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String p; // 수행할 함수
        int n; // 배열에 들어있는 수의 갯수
        Deque<Integer> queue; // 수를 담을 queue
        String list;
        String[] elements;

        for(int i = 0; i < T; i++) {
            p = br.readLine(); // 수행할 함수
            n = Integer.parseInt(br.readLine());

            queue = new ArrayDeque<>();
            list = br.readLine(); // 배열을 문자열 형태로 입력받음 [1,2,3,4]

            // 양끝의 대괄호 제거, 콤마 기준으로 split해서 숫자만 저장
            elements = list.substring(1, list.length()-1).split(",");

            for(String elem: elements){
                if(elem.equals("")){ // ""을 문자열로 인식하기 때문에 결과 error가 출력되지 않기 때문에 제외
                    continue;
                }
                queue.addLast(Integer.parseInt(elem));
            }

            boolean isError = false;
            boolean isReversed = false;
            for(char cmd: p.toCharArray()){ // 함수 실행 과정
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (queue.isEmpty()) {
                        isError = true;
                        sb.append("error").append("\n");
                        break;
                    } else if (isReversed) {
                        queue.removeLast();
                    } else if (!isReversed) {
                        queue.removeFirst();
                    }
                }
            }

            if(!isError){
                sb.append('[');
                if(queue.size() > 0){
                    if(isReversed){
                        sb.append(queue.removeLast());
                        while(!queue.isEmpty()){
                            sb.append(',').append(queue.removeLast());
                        }
                    }
                    else{
                        sb.append(queue.removeFirst());
                        while(!queue.isEmpty()){
                            sb.append(',').append(queue.removeFirst());
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}