import java.io.*;
import java.util.*;

public class Main {
   static int N, maxBlock = 0;
   static int[][] map;

   public static void main(String[] args) throws Exception {
      input();
      dfs(0, maxBlock, map);
      System.out.println(maxBlock);
   }

   private static void dfs(int depth, int max, int[][] map) {
      if (depth == 5) {
         maxBlock = Math.max(maxBlock, max);
         return;
      }
      for (int i = 0; i < 4; i++) {
         int[][] temp = new int[N][N];
         for (int j = 0; j < N; j++) {
            temp[j] = map[j].clone();
         }
         switch (i) {
            case 0: // 상
               moveTop(temp);
               break;
            case 1:
               moveBottom(temp);
               break;
            case 2:
               moveLeft(temp);
               break;
            case 3:
               moveRight(temp);
               break;

         }
         int currentMax = findMaxInBoard(temp);
         if (sameBoard(temp, map)) {
            maxBlock = Math.max(maxBlock, currentMax);
            continue;
         }
         dfs(depth + 1, currentMax, temp);
      }
   }

   private static int findMaxInBoard(int[][] temp) {
      int max = 0;
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            max = Math.max(max, temp[i][j]);
         }
      }
      return max;
   }

   private static boolean sameBoard(int[][] a, int[][] b) {
      for (int i = 0; i < N; i++) {

         if (!Arrays.equals(a[i], b[i]))
            return false;
      }
      return true;
   }

   // 위로 이동
   private static void moveTop(int[][] map) {
      for (int col = 0; col < N; col++) {
         List<Integer> list = new ArrayList<>();
         for (int row = 0; row < N; row++) {
            if (map[row][col] != 0)
               list.add(map[row][col]);
         }
         List<Integer> merged = new ArrayList<>();
         int idx = 0;
         while (idx < list.size()) {
            if (idx + 1 < list.size() && list.get(idx).equals(list.get(idx + 1))) {
               merged.add(list.get(idx) * 2);
               idx += 2;
            } else {
               merged.add(list.get(idx));
               idx++;
            }
         }
         for (int row = 0; row < N; row++) {
            map[row][col] = (row < merged.size()) ? merged.get(row) : 0;
         }
      }
   }

   // 아래로 이동
   private static void moveBottom(int[][] map) {
      for (int col = 0; col < N; col++) {
         List<Integer> list = new ArrayList<>();
         for (int row = N - 1; row >= 0; row--) {
            if (map[row][col] != 0)
               list.add(map[row][col]);
         }
         List<Integer> merged = new ArrayList<>();
         int idx = 0;
         while (idx < list.size()) {
            if (idx + 1 < list.size() && list.get(idx).equals(list.get(idx + 1))) {
               merged.add(list.get(idx) * 2);
               idx += 2;
            } else {
               merged.add(list.get(idx));
               idx++;
            }
         }
         for (int row = N - 1, k = 0; row >= 0; row--, k++) {
            map[row][col] = (k < merged.size()) ? merged.get(k) : 0;
         }
      }
   }

   // 왼쪽으로 이동
   private static void moveLeft(int[][] map) {
      for (int row = 0; row < N; row++) {
         List<Integer> list = new ArrayList<>();
         for (int col = 0; col < N; col++) {
            if (map[row][col] != 0)
               list.add(map[row][col]);
         }
         List<Integer> merged = new ArrayList<>();
         int idx = 0;
         while (idx < list.size()) {
            if (idx + 1 < list.size() && list.get(idx).equals(list.get(idx + 1))) {
               merged.add(list.get(idx) * 2);
               idx += 2;
            } else {
               merged.add(list.get(idx));
               idx++;
            }
         }
         for (int col = 0; col < N; col++) {
            map[row][col] = (col < merged.size()) ? merged.get(col) : 0;
         }
      }
   }

   // 오른쪽으로 이동
   private static void moveRight(int[][] map) {
      for (int row = 0; row < N; row++) {
         List<Integer> list = new ArrayList<>();
         for (int col = N - 1; col >= 0; col--) {
            if (map[row][col] != 0)
               list.add(map[row][col]);
         }
         List<Integer> merged = new ArrayList<>();
         int idx = 0;
         while (idx < list.size()) {
            if (idx + 1 < list.size() && list.get(idx).equals(list.get(idx + 1))) {
               merged.add(list.get(idx) * 2);
               idx += 2;
            } else {
               merged.add(list.get(idx));
               idx++;
            }
         }
         for (int col = N - 1, k = 0; col >= 0; col--, k++) {
            map[row][col] = (k < merged.size()) ? merged.get(k) : 0;
         }
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];

      for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < N; j++) {
            int n = Integer.parseInt(st.nextToken());
            map[i][j] = n;
            maxBlock = Math.max(maxBlock, map[i][j]);
         }
      }
   }
}