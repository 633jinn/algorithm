import java.io.*;
import java.util.*;

public class Main {
   static int R, C;
   static String[][] maze = new String[1000][1000];
   static boolean[][] visited_P = new boolean[1000][1000];
   static boolean[][] visited_F = new boolean[1000][1000];
   static PriorityQueue<Position> queue = new PriorityQueue<>(new Comparator<Position>() {
      @Override
      public int compare(Position p1, Position p2) {
         if (p1.time != p2.time) {
            return p1.time - p2.time;
         }
         if (p1.isFire != p2.isFire) {
            return p1.isFire ? 1 : -1;
         }
         return 0;
      }
   });
   static int[] dx = { 0, 0, -1, 1 };
   static int[] dy = { 1, -1, 0, 0 };

   static class Position {
      boolean isFire;
      int x;
      int y;
      int time;

      public Position(boolean isFire, int x, int y, int time) {
         this.isFire = isFire;
         this.x = x;
         this.y = y;
         this.time = time;
      }
   }

   public static void main(String[] args) throws Exception {
      input();
      while (!queue.isEmpty()) {
         Position position = queue.poll();
         
         // 현재 위치에 불이 번졌으면 pass
         if (!position.isFire && visited_F[position.x][position.y]) {
            continue;
         }
         // 지훈이 벽의 가장자리에 도착하면
         if (!position.isFire
               && ((position.x == 0 || position.x == R - 1) || (position.y == 0 || position.y == C - 1))) {
            System.out.println(position.time);
            return;
         }

         for (int i = 0; i < 4; i++) {
            int x = position.x + dx[i];
            int y = position.y + dy[i];
            // 벽을 만나면 pass
            if (x < 0 || x >= R || y < 0 || y >= C || maze[x][y].equals("#")) {
               continue;
            }

            if (!position.isFire && !visited_P[x][y] && !visited_F[x][y]) {
               visited_P[x][y] = true;
               queue.offer(new Position(false, x, y, position.time + 1));
            } else if (position.isFire && !visited_F[x][y]) {
               visited_F[x][y] = true;
               queue.offer(new Position(true, x, y, position.time + 1));
            }
         }
      }
      System.out.println("IMPOSSIBLE");
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] stringArray = br.readLine().split(" ");
      R = Integer.parseInt(stringArray[0]);
      C = Integer.parseInt(stringArray[1]);

      for (int i = 0; i < R; i++) {
         stringArray = br.readLine().split("");
         for (int j = 0; j < C; j++) {
            if (stringArray[j].equals("J")) {
               visited_P[i][j] = true;
               queue.offer(new Position(false, i, j, 1));
            } else if (stringArray[j].equals("F")) {
               visited_F[i][j] = true;
               queue.offer(new Position(true, i, j, 1));
            }
            maze[i][j] = stringArray[j];
         }
      }
   }
}