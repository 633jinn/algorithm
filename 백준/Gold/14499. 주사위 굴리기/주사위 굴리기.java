import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
   static int N, M, diceX, diceY, K;
   static int[][] board = new int[20][20];
   static int[] dx = { 0, 0, 0, -1, 1 }; // 동, 서, 북, 남
   static int[] dy = { 0, 1, -1, 0, 0 };
   static List<Integer> list = new ArrayList<>();

   static int[] dice = { 0, 0, 0, 0, 0, 0 };// 아래, 위, 서, 남, 동, 북

   public static void main(String[] args) throws Exception {
      input();
      for (int i = 0; i < K; i++) {
         int moveIdx = list.get(i);
         int moveX = diceX + dx[moveIdx];
         int moveY = diceY + dy[moveIdx];
         // 지도를 벗어난다면
         if (moveX >= N || moveX < 0 || moveY < 0 || moveY >= M) {
            continue;
         } else {
            diceX = moveX;
            diceY = moveY;
         }
         rollTheDice(moveIdx);
         if (board[moveX][moveY] == 0) {
            board[moveX][moveY] = dice[0];
         } else {
            dice[0] = board[moveX][moveY];
             board[moveX][moveY] = 0;
         }
         System.out.println(dice[1]);
      }
   }

   private static void rollTheDice(int moveIdx) {
      int[] newDice = new int[6];
      switch (moveIdx) {
         case 1: // 동쪽
            newDice = new int[] { dice[4], dice[2], dice[0], dice[3], dice[1], dice[5] };
            break;
         case 2: // 서쪽
            newDice = new int[] { dice[2], dice[4], dice[1], dice[3], dice[0], dice[5] };
            break;
         case 3: // 북쪽
            newDice = new int[] { dice[5], dice[3], dice[2], dice[0], dice[4], dice[1] };
            break;
         case 4: // 남쪽
            newDice = new int[] { dice[3], dice[5], dice[2], dice[1], dice[4], dice[0] };
            break;
         default:
            break;
      }
      dice = newDice;
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      diceX = Integer.parseInt(st.nextToken());
      diceY = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            board[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      list.addAll(Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList()));
   }
}