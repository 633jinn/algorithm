import java.io.*;
import java.util.*;

public class Main {
   static int T, W;
   static int[][][] dp;

   public static void main(String[] args) throws Exception {
      input();
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      T = Integer.parseInt(input[0]);
      W = Integer.parseInt(input[1]);

      dp = new int[T + 2][2][W + 1]; // 자두 개수

      for (int i = 1; i <= T; i++) {
         int fruit = Integer.parseInt(br.readLine());
         for (int j = 0; j < W + 1; j++) {
            if (1 == fruit) {
               // 현재 위치와 나무가 1일 때, 움직이지 않으면
               dp[i + 1][0][j] = Math.max(dp[i][0][j] + 1, dp[i + 1][0][j]);
               // 현재 위치와 나무가 2일 때, 움직이지 않으면
               dp[i + 1][1][j] = Math.max(dp[i][1][j], dp[i + 1][1][j]);
               if (j < W)// 현재 위치와 나무가 2일 때, 1로 움직이면
                  dp[i + 1][0][j + 1] = Math.max(dp[i][1][j] + 1, dp[i + 1][0][j + 1]);
            } else {
               // 현재 위치와 나무가 1일 때, 움직이지 않으면
               dp[i + 1][0][j] = Math.max(dp[i][0][j], dp[i + 1][0][j]);
               if (j > 0)
                  // 현재 위치와 나무가 2일 때, 움직이지 않으면
                  dp[i + 1][1][j] = Math.max(dp[i][1][j] + 1, dp[i + 1][1][j]);
               if (j < W)// 현재 위치와 나무가 1일 때, 2로 움직이면
                  dp[i + 1][1][j + 1] = Math.max(dp[i][0][j] + 1, dp[i + 1][1][j + 1]);
            }
         }
      }

      int max = 0;
      for (int i = 0; i < W + 1; i++) {
         max = Math.max(max, dp[T + 1][0][i]);
         max = Math.max(max, dp[T + 1][1][i]);
      }
      System.out.println(max);
   }
}