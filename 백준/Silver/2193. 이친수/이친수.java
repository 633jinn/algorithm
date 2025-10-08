import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static long[] arr = new long[91];

   public static void main(String[] args) throws Exception {
      input();
      arr[1] = 1;
      arr[2] = 1;
      for (int i = 3; i <= N; i++) {
         arr[i] = arr[i - 1] + arr[i - 2];
      }
      System.out.println(arr[N]);
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
   }
}