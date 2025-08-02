import java.io.*;
import java.util.*;

public class Main {
   static int n;
   static int[][] houses;
   static int[][] best;

   public static void main(String[] args) throws Exception {
      input();
      for (int i = 0; i < 3; i++) {
         best[0][i] = houses[0][i];
      }
      for (int i = 1; i < n; i++) {
         best[i][0] = Math.min(best[i - 1][1], best[i - 1][2]) + houses[i][0];
         best[i][1] = Math.min(best[i - 1][0], best[i - 1][2]) + houses[i][1];
         best[i][2] = Math.min(best[i - 1][0], best[i - 1][1]) + houses[i][2];
      }
      System.out.println(Arrays.stream(best[n - 1]).min().getAsInt());
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      houses = new int[n][3];
      best = new int[n][3];
      StringTokenizer st;
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 3; j++) {
            houses[i][j] = Integer.parseInt(st.nextToken());
         }
      }
   }
}