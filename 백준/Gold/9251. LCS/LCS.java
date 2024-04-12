import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] stringA = br.readLine().toCharArray();
        char[] stringB = br.readLine().toCharArray();
        br.close();

        int ALength = stringA.length;
        int BLength = stringB.length;

        int[][] LCS = new int[ALength + 1][BLength + 1];

        LCS[0][0] = 0;
        for(int i = 1; i < ALength + 1; i++) {
            for(int j = 1; j < BLength + 1; j++) {
                if(stringA[i - 1] == stringB[j - 1]) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                }
                else {
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
                }
            }
        }
        System.out.println(LCS[ALength][BLength]);
    }
}