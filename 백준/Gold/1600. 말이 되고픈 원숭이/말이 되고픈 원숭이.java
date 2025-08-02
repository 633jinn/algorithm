import java.io.*;
import java.util.*;

public class Main {
   static int k, w, h;
   static int[][] board;
   static int[][][] visited;
   static int[] mx = { 0, 0, 1, -1 }; // 원숭이 움직임
   static int[] my = { 1, -1, 0, 0 };
   static int[] hx = { -2, -2, -1, 1, 2, 2, 1, -1 }; // 말의 움직임
   static int[] hy = { -1, 1, 2, 2, 1, -1, -2, -2 };
   static Queue<Monkey> queue = new LinkedList<>();

   public static class Monkey {
      int x;
      int y;
      int k;
      int count;

      public Monkey(int x, int y, int k, int count) {
         this.x = x;
         this.y = y;
         this.k = k;
         this.count = count;
      }

   }

   public static void main(String[] args) throws Exception {
      input();
      visited[0][0][k] = 0;
      queue.offer(new Monkey(0, 0, k, 0));

      while (!queue.isEmpty()) {
         Monkey monkey = queue.poll();
         if (monkey.x == h - 1 && monkey.y == w - 1) {
            System.out.println(monkey.count);
            return;
         }
         if (monkey.k > 0) {
            moveLikeHorse(monkey);
         }
         moveLikeMonky(monkey);
      }
      System.out.println("-1");
   }

   public static void moveLikeHorse(Monkey monkey) {
      int x = monkey.x;
      int y = monkey.y;
      for (int i = 0; i < 8; i++) {
         x = monkey.x + hx[i];
         y = monkey.y + hy[i];
         if (isValid(x, y) && visited[x][y][monkey.k - 1] > monkey.count + 1) {
            visited[x][y][monkey.k - 1] = monkey.count + 1;
            queue.offer(new Monkey(x, y, monkey.k - 1, monkey.count + 1));
         }
      }
   }

   public static void moveLikeMonky(Monkey monkey) {
      int x = monkey.x;
      int y = monkey.y;
      for (int i = 0; i < 4; i++) {
         x = monkey.x + mx[i];
         y = monkey.y + my[i];
         if (isValid(x, y) && visited[x][y][monkey.k] > monkey.count + 1) {
            visited[x][y][monkey.k] = monkey.count + 1;
            queue.offer(new Monkey(x, y, monkey.k, monkey.count + 1));
         }
      }
   }

   public static boolean isValid(int x, int y) {
      if (x < 0 || x >= h || y < 0 || y >= w || board[x][y] == 1) {
         return false;
      }
      return true;
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      k = Integer.parseInt(br.readLine());

      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      board = new int[h][w];
      visited = new int[h][w][k + 1];

      for (int i = 0; i < h; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < w; j++) {
            board[i][j] = Integer.parseInt(st.nextToken());
            Arrays.fill(visited[i][j], Integer.MAX_VALUE);
         }
      }
   }
}
