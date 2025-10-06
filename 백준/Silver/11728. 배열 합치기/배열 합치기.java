import java.io.*;
import java.util.*;

public class Main {
   static int N, M;
   static int[] A, B;

   public static void main(String[] args) throws Exception {
      input();

      int idxA = 0;
      int idxB = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N + M; i++) {
         if (idxA == N) {
            sb.append(B[idxB++] + " ");
         } else if (idxB == M) {
            sb.append(A[idxA++] + " ");
         } else {
            if (A[idxA] < B[idxB]) {
            sb.append(A[idxA++] + " ");
            } else {
            sb.append(B[idxB++] + " ");
            }
         }
      }
      System.out.println(sb.toString());
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      A = new int[N];
      B = new int[M];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         A[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
         B[i] = Integer.parseInt(st.nextToken());
      }
   }
}