import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
   static int N;
   static int[] arr = new int[1_000_001 * 2];

   public static void main(String[] args) throws Exception {
      input();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 1_000_001 * 2; i++) {
         if (arr[i] > 0) {
            for (int j = 0; j < arr[i]; j++) {
               sb.append(i-1_000_000 + "\n");
            }
         }
      }
      System.out.print(sb.toString());
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

      for (int i = 0; i < N; i++) {
         arr[Integer.parseInt(br.readLine())+1_000_000]++;
      }
   }
}