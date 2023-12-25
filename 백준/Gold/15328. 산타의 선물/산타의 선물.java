import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            BigDecimal timeLimit = BigDecimal.valueOf(Long.parseLong(br.readLine()));
            BigDecimal timeCnt = BigDecimal.valueOf(0);

            st = new StringTokenizer(br.readLine());
            BigDecimal x1 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal y1 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal z1 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));

            // 유클리드 거리 계산
            BigDecimal nx = x1.multiply(x1);
            BigDecimal ny = y1.multiply(y1);
            BigDecimal nz = z1.multiply(z1);

            BigDecimal sum = sqrt(nx.add(ny).add(nz));
            timeCnt = timeCnt.add(sum);

            st = new StringTokenizer(br.readLine());
            BigDecimal x2 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal y2 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal z2 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));

            // 유클리드 거리 계산
            nx = x2.subtract(x1).multiply(x2.subtract(x1));
            ny = y2.subtract(y1).multiply(y2.subtract(y1));
            nz = z2.subtract(z1).multiply(z2.subtract(z1));

            sum = sqrt(nx.add(ny).add(nz));
            timeCnt = timeCnt.add(sum);

            st = new StringTokenizer(br.readLine());
            BigDecimal x3 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal y3 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal z3 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));

            // 유클리드 거리 계산
            nx = x3.subtract(x2).multiply(x3.subtract(x2));
            ny = y3.subtract(y2).multiply(y3.subtract(y2));
            nz = z3.subtract(z2).multiply(z3.subtract(z2));

            sum = sqrt(nx.add(ny).add(nz));
            timeCnt = timeCnt.add(sum);

            st = new StringTokenizer(br.readLine());
            BigDecimal x4 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal y4 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));
            BigDecimal z4 = BigDecimal.valueOf(Long.parseLong(st.nextToken()));

            // 유클리드 거리 계산
            nx = x4.subtract(x3).multiply(x4.subtract(x3));
            ny = y4.subtract(y3).multiply(y4.subtract(y3));
            nz = z4.subtract(z3).multiply(z4.subtract(z3));

            sum = sqrt(nx.add(ny).add(nz));
            timeCnt = timeCnt.add(sum);

            if (timeCnt.compareTo(timeLimit) > 0) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        br.close();
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    static BigDecimal sqrt(BigDecimal x) {
        return x.sqrt(MathContext.DECIMAL128);
    }
}