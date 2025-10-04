import java.io.*;
import java.util.*;

public class Main {
   static int N, M, K;
   static List<int[][]> list = new ArrayList<>();
   static boolean[][] laptop;

   public static void main(String[] args) throws Exception {
      input();
      int stickerIdx = 0;
      int direct = 0;
      while (stickerIdx < K) {
         if (search(stickerIdx) || direct == 5) {
            stickerIdx++;
            direct = 0;
         } else {
            rotate(stickerIdx, ++direct);
         }
      }
      int count = 0;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (laptop[i][j]) {
               count++;
            }
         }
      }
      System.out.println(count);
   }

   private static void rotate(int stickerIdx, int direct) {
      int[][] sticker = list.get(stickerIdx);
      int stickerR = sticker.length;
      int stickerC = sticker[0].length;
      int[][] temp = new int[stickerC][stickerR];
      int idxR = 0;
      int idxC = 0;
      for (int i = 0; i < stickerC; i++) {
         for (int j = stickerR - 1; j >= 0; j--) {
            temp[idxR][idxC++] = sticker[j][i];
            if (idxC == stickerR) {
               idxR++;
               idxC = 0;
            }
         }
      }
      list.set(stickerIdx, temp);
   }

   private static boolean search(int stickerIdx) {
      for (int r = 0; r < N; r++) {
         for (int c = 0; c < M; c++) {
            if (checkLaptop(r, c, stickerIdx)) {
               return true;
            }
         }
      }
      return false;
   }

   private static boolean checkLaptop(int r, int c, int i) {
      int[][] sticker = list.get(i);
      boolean[][] temp = new boolean[N][M];
      for (int j = 0; j < N; j++) {
         temp[j] = laptop[j].clone();
      }
      for (int j = 0; j < sticker.length; j++) {
         for (int j2 = 0; j2 < sticker[0].length; j2++) {
            if (r + j >= N || c + j2 >= M || (sticker[j][j2] == 1 && temp[r + j][c + j2])) {
               return false;
            }
            if(sticker[j][j2] == 1)
               temp[r + j][c + j2] = true;
         }
      }
      laptop = temp;
      return true;
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      laptop = new boolean[N][M];
      for (int i = 0; i < K; i++) {
         st = new StringTokenizer(br.readLine());
         int r = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         int[][] sticker = new int[r][c];

         for (int j = 0; j < r; j++) {
            st = new StringTokenizer(br.readLine());
            for (int j2 = 0; j2 < c; j2++) {
               sticker[j][j2] = Integer.parseInt(st.nextToken());
            }
         }
         list.add(sticker);
      }
   }
}