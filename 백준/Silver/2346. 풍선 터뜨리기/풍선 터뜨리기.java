import java.io.*;
import java.util.*;

public class Main {

    static class Balloon {
        int paperNum;
        int index;

        Balloon(int paperNum, int index) {
            this.paperNum = paperNum;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int balloonCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        Deque<Balloon> deque = new ArrayDeque<>();

        for(int i = 1; i <= balloonCnt; i++) {
            int paperNum = Integer.parseInt(st.nextToken()); // 종이에 적힌 값
            deque.add(new Balloon(paperNum, i));
        }

        while(true) {
            Balloon removed = deque.removeFirst();
            int removedPaper = removed.paperNum; // 종이 값
            int removedIndex = removed.index; // 풍선 순서

            sb.append(removedIndex).append(" ");

            if(deque.isEmpty()) {
                break;
            }

            if(removedPaper > 0) { // 종이 값이 양수이면
                for(int i = 0; i < removedPaper - 1; i++) { // 종이 값 - 1 만큼 iteration
                    Balloon temp = deque.removeFirst();
                    deque.add(temp);
                }
            }
            else if(removedPaper < 0) { // 음수면
                for(int i = 0; i > removedPaper; i--) { // 종이 값만큼 iteration
                    Balloon temp = deque.removeLast();
                    deque.addFirst(temp);
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}