import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
   static int N, M, answer = 64;
   static int[][] arr;
   static List<int[]> cctv = new ArrayList<>();
   static List<int[]> cctv5type = new ArrayList<>();

   public static void main(String[] args) throws Exception {
      int blindSpot = input();
      // answer = blindSpot;
      backTracking(0, cctv, blindSpot, arr);

      System.out.println(answer);
   }

   private static void backTracking(int idx, List<int[]> cctv, int blindSpot, int[][] arr) {
      if (idx == cctv.size()) {
         answer = Math.min(answer, blindSpot);
         return;
      }
      for (int j = 0; j < 4; j++) {
         int[] c = cctv.get(idx);
         if (arr[c[0]][c[1]] == 1 && ((c[0] == 0 && j == 0) || (c[0] == N - 1 && j == 1) || (c[1] == 0 && j == 2)
               || (c[1] == M - 1 && j == 3))) {
            continue;
         }
         int[][] temp = new int[N][M];
         deepCopy(temp, arr);
         int spot = setCCTV(arr[c[0]][c[1]], j, c[0], c[1]);
         backTracking(idx + 1, cctv, blindSpot - spot, arr);
         deepCopy(arr, temp);
      }

   }

   private static void deepCopy(int[][] temp, int[][] arr) {
      for (int i = 0; i < arr.length; i++) {
         temp[i] = arr[i].clone(); // 각 행을 복사
      }
   }

   private static int input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      arr = new int[N][M];
      int blindSpot = N * M;
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) {
               continue;
            }
            if (arr[i][j] == 0) { // 사각지대 계산이 이미 된 타일이 아니라면
               blindSpot--;
            }
            if (type == 5) {
               cctv5type.add(new int[] { i, j });
            } else if (type >= 1 && type < 5) {
               cctv.add(new int[] { i, j });
            }
            arr[i][j] = type;
         }
      }
      for (int i = 0; i < cctv5type.size(); i++) {
         int[] c = cctv5type.get(i);
         blindSpot -= setCCTV(5, 0, c[0], c[1]);
      }
      return blindSpot;
   }

   private static int setCCTV(int type, int direct, int r, int c) {
      if (type == 1) {
         switch (direct) {
            case 0:
               return top(r, c);
            case 1:
               return bottom(r, c);
            case 2:
               return left(r, c);
            default:
               return right(r, c);
         }
      }
      if (type == 2) {
         switch (direct) {
            case 0:
               return top(r, c) + bottom(r, c);
            case 2:
               return top(r, c) + bottom(r, c);
            default:
               return left(r, c) + right(r, c);
         }
      }
      if (type == 3) {
         switch (direct) {
            case 0:
               return top(r, c) + right(r, c);
            case 1:
               return right(r, c) + bottom(r, c);
            case 2:
               return left(r, c) + bottom(r, c);
            default:
               return top(r, c) + left(r, c);
         }
      }
      if (type == 4) {
         switch (direct) {
            case 0:
               return top(r, c) + right(r, c) + bottom(r, c);
            case 1:
               return left(r, c) + right(r, c) + bottom(r, c);
            case 2:
               return left(r, c) + top(r, c) + bottom(r, c);
            default:
               return top(r, c) + right(r, c) + left(r, c);
         }
      }
      if (type == 5) {
         return top(r, c) + bottom(r, c) + right(r, c) + left(r, c);
      }
      return 0;
   }

   private static int right(int r, int c) {
      // cctv 기준 오른쪽
      int count = 0;
      for (int i = c + 1; i < M; i++) {
         if (arr[r][i] == 0) {
            arr[r][i] = -1;
            count++;
         } else if (arr[r][i] == 6)
            break;
         else
            continue;
      }
      return count;
   }

   private static int left(int r, int c) {
      // cctv 기준 왼쪽
      int count = 0;
      for (int i = c - 1; i >= 0; i--) {
         if (arr[r][i] == 0) {
            arr[r][i] = -1;
            count++;
         } else if (arr[r][i] == 6) {
            break;
         } else
            continue;
      }
      return count;
   }

   private static int top(int r, int c) {
      // cctv 기준 위쪽
      int count = 0;
      for (int i = r - 1; i >= 0; i--) {
         if (arr[i][c] == 0) {
            arr[i][c] = -1;
            count++;
         } else if (arr[i][c] == 6) {
            break;
         } else
            continue;
      }
      return count;
   }

   private static int bottom(int r, int c) {
      // cctv 기준 아래
      int count = 0;
      for (int i = r + 1; i < N; i++) {
         if (arr[i][c] == 0) {
            arr[i][c] = -1;
            count++;
         } else if (arr[i][c] == 6) {
            break;
         } else
            continue;
      }
      return count;
   }
}