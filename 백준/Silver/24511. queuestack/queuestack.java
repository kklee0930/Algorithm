import java.io.*;
import java.util.*;

public class Main {

    static int[] dataStructure;
    static int n;
    static ArrayDeque<Integer> queueStack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dataStructure = new int[n]; // 큐 스택 판별용
        queueStack = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            dataStructure[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 큐일 경우에만 추가 및 제거 작업. 스택일 경우에는 추가하고 제거하는 값이 같기 때문에 스킵
            if(dataStructure[i] == 0) {
                queueStack.add(num);
            }
        }

        int givenLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        br.close();

        for(int i = 0; i < givenLength; i++) {
            int givenNumber = Integer.parseInt(st.nextToken());
            sb.append(queueStackOperation(givenNumber)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int queueStackOperation(int givenNumber) {
        queueStack.addFirst(givenNumber);
        givenNumber = queueStack.removeLast();

        return givenNumber;
    }
}