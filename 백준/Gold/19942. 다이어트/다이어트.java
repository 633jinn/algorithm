import java.io.*;
import java.util.*;

public class Main {
   static int M;
   static int[][] nutrient;
   static boolean[] visited;
   static PriorityQueue<Integer> result = new PriorityQueue<>();
   static int price = Integer.MAX_VALUE;
   static int[] goal = new int[4];

   public static void main(String[] args) throws Exception {
      input();

      int checkPrice = 0;
      ArrayDeque<Integer> list = new ArrayDeque<>();
      backTracking(goal, 0, list, checkPrice, 0, 0, 0, 0);
      if (result.size() == 0) {
         System.out.println("-1");
         return;
      }

      System.out.println(price);
      StringBuilder sb = new StringBuilder();
      while (!result.isEmpty()) {
         int r = result.poll();
         sb.append(r + 1 + " ");
      }
      System.out.println(sb.toString());
   }

   private static void backTracking(int[] goal, int idx, ArrayDeque<Integer> list, int checkPrice, int mp, int mf,
         int ms, int mv) {
      boolean flag = true;
      if (mp < goal[0] || mf < goal[1] || ms < goal[2] || mv < goal[3]) {
         flag = false;
      }
      if (checkPrice >= price) {
         return;
      }
      if (flag) {
         if (checkPrice < price) {
            result = new PriorityQueue<>(list);
            price = checkPrice;
         }
         return;
      }
      for (int i = idx; i < M; i++) {
         if (!visited[i]) {
            visited[i] = true;
            list.add(i);
            backTracking(goal, i, list, checkPrice + nutrient[i][4], mp + nutrient[i][0], mf + nutrient[i][1],
                  ms + nutrient[i][2], mv + nutrient[i][3]);
            visited[i] = false;
            list.pollLast();
         }
      }

   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      M = Integer.parseInt(br.readLine());
      StringTokenizer st;
      nutrient = new int[M][5];
      visited = new boolean[M];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 4; i++) {
         goal[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 5; j++) {
            nutrient[i][j] = Integer.parseInt(st.nextToken());
         }
      }
   }
}
