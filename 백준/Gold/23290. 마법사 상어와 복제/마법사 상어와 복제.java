import java.io.*;
import java.util.*;

public class Main {
   static int M, S;
   static int[][] board = new int[5][5];
   static int[][] smell = new int[5][5];
   static int[] shark = new int[2];
   static int[] fx = { 0, -1, -1, -1, 0, 1, 1, 1 };// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
   static int[] fy = { -1, -1, 0, 1, 1, 1, 0, -1 };
   static int[] sx = { -1, 0, 1, 0 }; // ↑, ←, ↓, →
   static int[] sy = { 0, -1, 0, 1 };
   static ArrayDeque<Fish> deque = new ArrayDeque<>();
   static ArrayDeque<Fish> copy = new ArrayDeque<>();
   static ArrayDeque<Fish> sharkMove = new ArrayDeque<>();
   static int maxValue = -1;

   static class Fish {
      int x;
      int y;
      int direct;

      public Fish(int x, int y, int direct) {
         this.x = x;
         this.y = y;
         this.direct = direct;
      }
   }

   public static void main(String[] args) throws Exception {
      input();
      for (int i = 0; i < S; i++) {
         // 1
         copyMagic();
         int size = deque.size();
         for (int j = 0; j < size; j++) {
            Fish fish = deque.poll();
            // System.out.println("x: " + fish.x + " y: " + fish.y + " direct: " + fish.direct);
            // 2
            boolean flag = false;
            for (int k = 0; k < 8; k++) {
               int direct = (fish.direct - k + 8) % 8;
               int dx = fish.x + fx[direct];
               int dy = fish.y + fy[direct];
               if (dx < 1 || dx > 4 || dy < 1 || dy > 4)
                  continue; // 격자를 넘어설 때
               if (shark[0] == dx && shark[1] == dy)
                  continue; // 상어 칸으로 갈 때
               if (smell[dx][dy] > 0)
                  continue; // 물고기 냄새 칸으로 갈때
               flag = true;

               board[fish.x][fish.y] -= 1;
               deque.offer(new Fish(dx, dy, direct));
               board[dx][dy] += 1;

               break;
            }
            if (!flag)
               deque.offer(fish);
         }

         // 3
         int[][] move = new int[3][2];
         boolean[][] visited = new boolean[5][5];

         maxValue = -1;
         moveShark(visited, 0, move, 0, new int[3][2], shark[0], shark[1]);

         // 상어 움직임 업데이트
         shark[0] = move[2][0];
         shark[1] = move[2][1];

         Set<String> eatenCells = new HashSet<>();
         for (int j = 0; j < 3; j++) {
            if (board[move[j][0]][move[j][1]] > 0) {
               eatenCells.add(move[j][0] + "," + move[j][1]);
               board[move[j][0]][move[j][1]] = 0;
               smell[move[j][0]][move[j][1]] = 3;
            }
         }
         // deque에서 먹힌 물고기들 제거
         for (int j = 0; j < size; j++) {
            Fish fish = deque.poll();
            if (!eatenCells.contains(fish.x + "," + fish.y)) {
               deque.offer(fish);
            }
         }

         // 4
         for (int j = 1; j < 5; j++) {
            for (int j2 = 1; j2 < 5; j2++) {
               if (smell[j][j2] > 0) {
                  smell[j][j2]--;
               }
            }
         }

         // 5
         int c_size = copy.size();
         for (int j = 0; j < c_size; j++) {
            Fish c = copy.poll();
            deque.add(c);
            board[c.x][c.y] += 1;
         }
      }
      int answer = 0;
      for (int i = 1; i < 5; i++) {
         for (int j = 1; j < 5; j++) {
            if (board[i][j] > 0) {
               answer += board[i][j];
            }
         }
      }
      System.out.println(answer);
   }

   private static void moveShark(boolean[][] visited, int count, int[][] sharkMove, int sum,
         int[][] arr, int x, int y) {
      if (count == 3) {
         if (maxValue < sum) {
            for (int i = 0; i < 3; i++) {
               sharkMove[i][0] = arr[i][0];
               sharkMove[i][1] = arr[i][1];
            }
            maxValue = sum;
         }
         return;
      }
      for (int i = 0; i < 4; i++) {
         int dx = x + sx[i];
         int dy = y + sy[i];
         if (dx < 1 || dx > 4 || dy < 1 || dy > 4)
            continue; // 격자를 넘어설 때
         arr[count][0] = dx;
         arr[count][1] = dy;
         if (visited[dx][dy])
            moveShark(visited, count + 1, sharkMove, sum, arr, dx, dy);
         else {
            visited[dx][dy] = true;
            moveShark(visited, count + 1, sharkMove, sum + board[dx][dy], arr, dx, dy);
            visited[dx][dy] = false;
         }
      }

   }

   private static void copyMagic() {
      for (Fish fish : deque) {
         copy.offer(new Fish(fish.x, fish.y, fish.direct));
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      S = Integer.parseInt(st.nextToken());

      // 물고기
      for (int i = 0; i < M; i++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         int direct = Integer.parseInt(st.nextToken());
         board[x][y] += 1;
         deque.offer(new Fish(x, y, direct - 1));
      }

      // 상어
      st = new StringTokenizer(br.readLine());
      shark[0] = Integer.parseInt(st.nextToken());
      shark[1] = Integer.parseInt(st.nextToken());
   }
}
