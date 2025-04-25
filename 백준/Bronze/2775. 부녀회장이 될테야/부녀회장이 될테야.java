import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int k, n;
    static int[][] person, sum;

    public static void main(String[] args) throws IOException {
        input();

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            person = new int[k + 1][n + 1];
            sum = new int[k + 1][n + 1];
            solution();
        }
    }

    private static void solution() {
        // 0층 인원 수 세팅
        for (int j = 1; j <= n; j++) {
            person[0][j] = j;
            sum[0][j] = sum[0][j - 1] + person[0][j];
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                person[i][j] = sum[i - 1][j];
                sum[i][j] = sum[i][j - 1] + person[i][j];
            }
        }
        System.out.println(person[k][n]);
    }
}