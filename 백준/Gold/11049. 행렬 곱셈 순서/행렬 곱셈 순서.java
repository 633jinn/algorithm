import java.io.*;
import java.util.*;

/**
 * 플로이드 와샬
 */
public class Main {
   static int N;
   static int[][] matrix = new int[501][2];
   static long[][] dp = new long[501][501]; // dp[i][j] = i에서 j까지의 행렬곱의 최소값
   static int INF = Integer.MAX_VALUE;

   public static void main(String[] args) throws Exception {
      input();
      for (int range = 1; range < N; range++) { // 범위 - i가 1이고 j가 3일 때 범위는 2
         for (int i = 0; i < N - range; i++) {
            dp[i][i + range] = INF;
            for (int j = i; j < i + range; j++) {
               long val = dp[i][j] + dp[j + 1][i + range] + matrix[i][0] * matrix[j][1] * matrix[i + range][1];
               dp[i][i + range] = Math.min(dp[i][i + range], val);
            }
         }
      }
      System.out.println(dp[0][N - 1]);
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

      StringTokenizer st;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         matrix[i][0] = Integer.parseInt(st.nextToken());
         matrix[i][1] = Integer.parseInt(st.nextToken());
      }
   }
}