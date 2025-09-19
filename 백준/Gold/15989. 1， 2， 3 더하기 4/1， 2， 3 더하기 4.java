import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * 1 = 1
 * 2 = 1+1, 2 = 2
 * 3 = 1+1+1, 2+1, 3 = 3(4-1)
 * 4 = 1+1+1+1, 2+1+1, 3+1, (1+1+2), 2+2, (1+3) = 4(6-2)
 * 5 = 1+1+1+1+1, 2+1+1+1, 3+1+1, 2+2+1, 3+2 = 5(9-4)
 * 6 = 1+1+1+1+1+1, 2+1+1+1, 3+1+1+1, 2+2+1+1, 3+2+1, 2+2+2, 3+3 = 7(12-5)
 * 7 = 1+1+1+1+1+1+1, 2+1+1+1+1, 3+1+1+1+1, 2+2+1+1+1, 3+2+1+1, 2+2+2+1, 3+3+1,
 * 3+2+2 = 8(16-8)
 * 8 = 1+1+1+1+1+1+1+1, 2+1+1+1+1+1, 3+1+1+1+1+1, 2+2+1+1+1+1, 3+2+1+1+1,
 * 2+2+2+1+1, 3+3+1+1, 3+2+2+1, 2+2+2+2 + 3+3+2 = 10(20-10)
 * 9 = 1+1+1+1+1+1+1+1+1, 2+1+1+1+1+1+1, 3+1+1+1+1+1+1, 2+2+1+1+1+1+1,
 * 3+2+1+1+1+1, 2+2+2+1+1+1, 3+3+1+1+1, 3+2+2+1+1, 2+2+2+2+1, 3+3+2+1,
 * 3+3+2+2+2, 3+3+3 = 12
 */
public class Main {
   static int T, idx = 8;
   static int[][] dp = new int[10001][4];

   public static void main(String[] args) throws Exception {
      dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
      for (int j = 4; j <= 10000; j++) {
         dp[j][1] = dp[j - 1][1];
         dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
         dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
      }

      input();
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      T = Integer.parseInt(br.readLine());
      for (int i = 0; i < T; i++) {
         int N = Integer.parseInt(br.readLine());
         System.out.println(Arrays.stream(dp[N]).sum());
      }
   }
}