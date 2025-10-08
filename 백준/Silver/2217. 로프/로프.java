import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static ArrayList<Integer> list = new ArrayList<>();

   public static void main(String[] args) throws Exception {
      input();
      int max = 0;
      int count = N;
      for (Integer i : list) {
         max = Math.max(max, count * i);
         count--;
      }
      System.out.println(max);
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      for (int i = 0; i < N; i++) {
         list.add(Integer.parseInt(br.readLine()));
      }
      Collections.sort(list);
   }
}