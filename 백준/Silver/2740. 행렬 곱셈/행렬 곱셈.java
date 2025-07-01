import java.io.*;
import java.util.*;

public class Main {
    static int[][] A, B, result;
    static int n, m, k;

    public static void main(String[] args) throws Exception {
        input();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int j2 = 0; j2 < k; j2++) {
                    result[i][j2] += A[i][j] * B[j][j2];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j]);
                if (j == k-1) {
                    System.out.println();
                }else{
                    System.out.print(" ");
                }
            }
        }
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        B = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[n][k];
    }
}