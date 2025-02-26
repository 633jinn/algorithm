import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static String[][] arr;
    static int maxNum = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        if (N == 1 && M == 1) {
            int num = Integer.parseInt(arr[0][0]);
            double doubleNum = Math.sqrt(num);
            if (doubleNum == (int) doubleNum) {
                maxNum = num;
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < N; k++) {
                        for (int k2 = 0; k2 < M; k2++) {
                            if (k == 0 && k2 == 0) {
                                continue;
                            }
                            find(i, j, k, k2, "");
                            find(i, j, k, k2 * (-1), "");
                            find(i, j, k * (-1), k2, "");
                            find(i, j, k * (-1), k2 * (-1), "");
                        }
                    }
                }
            }
        }
        bw.write(maxNum + "\n");
        bw.flush();
        bw.close();
    }

    private static void find(int row, int column, int stepRow, int stepColumn, String answer) {

        while (true) {
            if (!answer.equals("")) {
                String reversed = new StringBuilder(answer).reverse().toString();
                double sqrtNum = Math.sqrt(Integer.parseInt(answer));
                double reversedSqrtNum = Math.sqrt(Integer.parseInt(reversed));
                if (sqrtNum == (int) sqrtNum) {
                    maxNum = Math.max(maxNum, Integer.parseInt(answer));
                }
                if (reversedSqrtNum == (int) reversedSqrtNum) {
                    maxNum = Math.max(maxNum, Integer.parseInt(reversed));
                }
            }
            if (row >= N || row < 0 || column >= M || column < 0) {
                return;
            }
            
            answer += arr[row][column];
            row += stepRow;
            column += stepColumn;
        }
    }
}