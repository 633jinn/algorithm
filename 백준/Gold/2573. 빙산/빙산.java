import java.io.*;
import java.util.*;

public class Main {
   static int N, M;
   static int[][] map;
   static Queue<int[]> temp = new LinkedList<>();
   static Queue<int[]> glaciers = new LinkedList<>();
   static int[] dx = { 0, 0, -1, 1 };
   static int[] dy = { -1, 1, 0, 0 };

   public static void main(String[] args) throws Exception {
      input();
      int glacierCount = glaciers.size();
      int startCount = glacierCount;
      int year = 1;
      while (!glaciers.isEmpty()) {
         int[] glacier = glaciers.poll();
         int x = glacier[0];
         int y = glacier[1];
         startCount--;

         int seas = findSeas(x, y);
         // 빙하가 녹으면
         if (map[x][y] - seas <= 0) {
            glacierCount--;
            temp.offer(new int[] { x, y });
         } else {
            map[x][y] -= seas;
            glaciers.offer(glacier);
         }

         if (startCount == 0) {

            while (!temp.isEmpty()) {
               int[] t = temp.poll();
               map[t[0]][t[1]] = 0;
            }
            // 빙산이 나뉘면
            if (glaciers.isEmpty())
               break;
            if (bfs(glacierCount, glaciers.peek())) {
               System.out.println(year);
               return;
            }
            // 나뉘지 않으면
            year++;
            // 값 초기화
            startCount = glacierCount;
         }
      }
      System.out.println(0);
      return;
   }

   private static int findSeas(int x, int y) {
      int count = 0;
      for (int i = 0; i < 4; i++) {
         int moveX = x + dx[i];
         int moveY = y + dy[i];
         if ((moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) && map[moveX][moveY] == 0) {
            count++;
         }
      }
      return count;
   }

   private static boolean bfs(int glacierCount, int[] glacier) {
      Queue<int[]> queue = new LinkedList<>();
      queue.offer(glacier);
      int count = 1;
      boolean[][] visited = new boolean[N][M];
      visited[glacier[0]][glacier[1]] = true;
      while (!queue.isEmpty()) {
         int[] g = queue.poll();
         int x = g[0];
         int y = g[1];
         for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if (!(moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) || visited[moveX][moveY]
                  || map[moveX][moveY] == 0)
               continue;
            count++;
            visited[moveX][moveY] = true;
            queue.offer(new int[] { moveX, moveY });
         }
      }
      // 빙산이 나누어지면 1, 아니면 0
      return count != glacierCount ? true : false;
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      map = new int[N][M];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
            if (map[i][j] != 0) {
               // 빠르게 빙하를 찾기위한 연결 리스트
               glaciers.add(new int[] { i, j });
            }
         }

      }
   }
}