import java.io.*;
import java.util.*;

public class Main {
   static int R, C;
   static String[][] map = new String[12][12];
   static int[] moveR = { 1, 0, -1, 0 };
   static int[] moveC = { 0, -1, 0, 1 };
   static String[][] after50 = new String[12][12];

   public static void main(String[] args) throws Exception {
      input();

      int[] leftEdge = new int[] { 11, 11 };
      int[] rightEdge = new int[] { -1, -1 };
      for (int i = 0; i < R; i++) {
         for (int j = 0; j < C; j++) {

            if (map[i][j].equals(".")) {
               after50[i][j] = ".";
               continue;
            }

            int closer = 0;
            for (int k = 0; k < 4; k++) {
               int r = i + moveR[k];
               int c = j + moveC[k];
               if (r < 0 || r >= R || c < 0 || c >= C || map[r][c].equals(".")) {
                  closer++;
               }
            }
            if (closer >= 3) {
               after50[i][j] = ".";
            } else {
               after50[i][j] = "X";
               if (leftEdge[0] > i) {
                  leftEdge[0] = i;
               }
               if (leftEdge[1] > j) {
                  leftEdge[1] = j;
               }
               if (rightEdge[0] < i) {
                  rightEdge[0] = i;
               }
               if (rightEdge[1] < j) {
                  rightEdge[1] = j;
               }
            }
         }
      }
      for (int i = leftEdge[0]; i <= rightEdge[0]; i++) {
         for (int j = leftEdge[1]; j <= rightEdge[1]; j++) {
            System.out.print(after50[i][j]);
         }
         System.out.println();
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      for (int i = 0; i < R; i++) {
         String[] tmp = br.readLine().split("");
         for (int j = 0; j < C; j++) {
            map[i][j] = tmp[j];
         }
      }
   }
}