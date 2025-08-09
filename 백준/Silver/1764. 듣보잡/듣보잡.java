import java.io.*;
import java.util.*;

/**
 * KMP 알고리즘
 */
public class Main {
   static int N, M;
   static HashMap<String, Integer> map = new HashMap<>();
   static PriorityQueue<String> noListennoSee = new PriorityQueue<>();

   public static void main(String[] args) throws Exception {
      input();
      int size = noListennoSee.size();
      System.out.println(size);
      for (int i = 0; i < size; i++) {
         System.out.println(noListennoSee.poll());
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] string = br.readLine().split(" ");
      N = Integer.parseInt(string[0]);
      M = Integer.parseInt(string[1]);
      for (int i = 0; i < N; i++) {
         map.put(br.readLine(), 1);
      }
      for (int i = 0; i < M; i++) {
         String person = br.readLine();
         if (map.containsKey(person)) {
            noListennoSee.offer(person);
         }
      }
   }
}
