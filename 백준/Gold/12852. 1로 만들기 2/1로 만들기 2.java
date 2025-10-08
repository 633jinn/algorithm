import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static int[] arr, move;

   public static void main(String[] args) throws Exception {
      input();

      arr[1] = 0;
      for (int i = 1; i < N; i++) {
         if (i * 3 <= N && arr[i * 3] > arr[i] + 1) {
            arr[i * 3] = arr[i] + 1;
            move[i * 3] = i;
         }
         if (i * 2 <= N && arr[i * 2] > arr[i] + 1) {
            arr[i * 2] = arr[i] + 1;
            move[i * 2] = i;
         }
         if (arr[i + 1] > arr[i] + 1) {
            arr[i + 1] = arr[i] + 1;
            move[i + 1] = i;
         }
      }
      StringBuilder sb = new StringBuilder();
      sb.append(arr[N] + "\n");
      int idx = N;
      sb.append(idx + " ");
      while (idx != 1) {
         sb.append(move[idx] + " ");
         idx = move[idx];
      }
      System.out.println(sb.toString());
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      arr = new int[N + 1];
      Arrays.fill(arr, Integer.MAX_VALUE);
      move = new int[N + 1];
   }
}