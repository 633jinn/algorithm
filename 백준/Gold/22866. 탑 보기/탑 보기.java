import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static int[] height;
   static int[][] building;

   public static void main(String[] args) throws Exception {

      // 입력
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      building = new int[N + 1][2]; // [0]: 보이는 건물 갯수, [1]: 작은 건물 번호
      height = new int[N + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         height[i + 1] = Integer.parseInt(st.nextToken());
         building[i + 1][1] = Integer.MAX_VALUE;
      }

      Deque<Integer> dequeL = new LinkedList<>();
      Deque<Integer> dequeR = new LinkedList<>();
      for (int i = 1; i <= N; i++) {
         // 왼쪽에 보이는 빌딩 찾기
         while (!dequeL.isEmpty() && height[dequeL.peekLast()] <= height[i]) {
            dequeL.pollLast();
         }

         building[i][0] += dequeL.size();
         if (dequeL.size() != 0) {
            // 가장 가깝거나 작은 건물 번호 찾기
            int closer = dequeL.peekLast();
            int absBefore = Math.abs(i - building[i][1]);
            int absAfter = Math.abs(i - closer);
            if (absBefore > absAfter) {
               building[i][1] = closer;
            } else if (absBefore == absAfter) {
               building[i][1] = Math.min(building[i][1], closer);
            }
         }

         // 빌딩 추가하기
         dequeL.offer(i);

         // 오른쪽에 보이는 빌딩 찾기
         while (!dequeR.isEmpty() && height[dequeR.peekLast()] <= height[N - i + 1]) {
            dequeR.pollLast();
         }

         building[N - i + 1][0] += dequeR.size();
         if (dequeR.size() != 0) {

            // 가장 가깝거나 작은 건물 번호 찾기
            int closer = dequeR.peekLast();
            int absBefore = Math.abs(N - i + 1 - building[N - i + 1][1]);
            int absAfter = Math.abs(N - i + 1 - closer);
            if (absBefore > absAfter) {
               building[N - i + 1][1] = closer;
            } else if (absBefore == absAfter) {
               building[N - i + 1][1] = Math.min(building[N - i + 1][1], closer);
            }
         }
         // 빌딩 추가하기
         dequeR.offer(N - i + 1);
      }

      for (int i = 1; i <= N; i++) {
         if (building[i][0] == 0) {
            System.out.println(0);
         } else {
            System.out.println(building[i][0] + " " + building[i][1]);
         }
      }
   }
}