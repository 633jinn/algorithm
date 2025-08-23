import java.io.*;
import java.util.*;

/**
 * 플로이드 와샬
 */
public class Main {
   static int N, M;
   static int[][] map = new int[101][101];

   public static void main(String[] args) throws Exception {
      input();
      for (int k = 1; k <= N; k++) { // 경유지를 가장 먼저 for문으로 돌려주는 것이 핵심
         for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
               map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
            }
         }
      }
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            int result = map[i][j] == 100_001*N ? 0 : map[i][j];
            System.out.print(result + " ");
         }
         System.out.println();
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      M = Integer.parseInt(br.readLine());
      for (int i = 0; i <= N; i++) {
         Arrays.fill(map[i], 100_001*N);
         map[i][i] = 0;
      }
      for (int i = 0; i < M; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         int c = Integer.parseInt(st.nextToken());
         map[a][b] = Math.min(map[a][b], c);
      }
   }
}
