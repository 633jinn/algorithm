import java.io.*;
import java.util.*;

public class Main {
   static int N;

   public static void main(String[] args) throws Exception {
      input();
      int count = 0;
      long num = 1;
      int n = 1;
      if (N < 10) {
         System.out.println(N);
         return;
      }
      while (num <= N) {
         if (num * 10 > N) {
            count += (N - num + 1) * n;
         } else {
            count += (num * 10 - num) * n;
         }
         num *= 10;
         n++;
      }
      System.out.println(count);
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
   }
}
