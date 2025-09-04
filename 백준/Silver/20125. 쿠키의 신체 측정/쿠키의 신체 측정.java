import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static boolean[][] board;
   static int[] heart;
   static int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      board = new boolean[N + 1][N + 1];

      boolean flag = false;
      for (int i = 1; i < N + 1; i++) {
         String[] body = br.readLine().split("");
         for (int j = 1; j < N + 1; j++) {
            String s = body[j-1];
            if (!s.equals("*")) {
               continue;
            }
            if (!flag) {
               flag = true;
               heart = new int[] { i + 1, j };
            } else {
               if (heart[0] == i) {
                  if (j < heart[1]) {
                     leftArm++;
                  } else if (j > heart[1]) {
                     rightArm++;
                  }
               } else {
                  if (j == heart[1]) {
                     waist++;
                  } else if (j == heart[1] - 1) {
                     leftLeg++;
                  } else {
                     rightLeg++;
                  }
               }
            }
         }
      }
      System.out.println(String.format("%d %d", heart[0], heart[1]));
      System.out.println(String.format("%d %d %d %d %d", leftArm, rightArm, waist, leftLeg, rightLeg));
   }

}