import java.io.*;
import java.util.*;

public class Main {
   static int l;
   static boolean[][] visited;
   static int[] now = new int[2];
   static int[] goal = new int[2];
   static Deque<int[]> queue = new ArrayDeque<>();
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
   static int[] dy = { -2, -1, 1, 2, -2, -1, 1, 2 };

   public static void main(String[] args) throws Exception {
      int T = Integer.parseInt(br.readLine());

      for (int i = 0; i < T; i++) {
         input();
         queue.offer(new int[] { now[0], now[1], 0 });
         visited[now[0]][now[1]] = true;

         while (!queue.isEmpty()) {
            int[] knight = queue.poll();
            if (knight[0] == goal[0] && knight[1] == goal[1]) {
               System.out.println(knight[2]);
               break;
            }
            for (int j = 0; j < 8; j++) {
               int x = knight[0] + dx[j];
               int y = knight[1] + dy[j];
               if (!(x >= 0 && y >= 0 && x < l && y < l) || visited[x][y]) {
                  continue;
               }
               int count = knight[2] + 1;
               visited[x][y] = true;
               queue.offer(new int[] { x, y, count});
            }
         }
      }
   }

   private static void input() throws Exception {
      l = Integer.parseInt(br.readLine());
      visited = new boolean[l][l];
      String[] strings = br.readLine().split(" ");
      now = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
      strings = br.readLine().split(" ");
      goal = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
      queue.clear();
   }
}
