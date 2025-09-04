import java.io.*;
import java.util.*;

public class Main {
   static int N;
   static int p1, p2;
   // static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] -
   // o1[0]);

   // 배낭 문제, PQ를 이용해 coin 값에 따라 Desc되도록 한 뒤 윤화와 준희에게 나눠준다.
   // //왜 그리디는 안되는걸까???
   // public static void main(String[] args) throws Exception {
   // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   // for (int i = 0; i < 3; i++) {
   // N = Integer.parseInt(br.readLine());
   // p1 = 0;
   // p2 = 0;
   // for (int j = 0; j < N; j++) {
   // int[] input = Arrays.stream(br.readLine().split("
   // ")).mapToInt(Integer::parseInt).toArray();
   // pq.offer(input);
   // }

   // while (!pq.isEmpty()) {
   // int[] input = pq.poll();
   // int coin = input[0];
   // int count = input[1];
   // // p1와 p2의 차이 비교, 그 차 만큼 coin을 이용해 유사하도록 값을 더한다.
   // int abs = Math.abs(p1 - p2);
   // int div = abs / coin;
   // if (p1 >= p2 && count >= div) {
   // p2 += coin * (div);
   // } else if (count >= div) {
   // p1 += coin * (div);
   // }
   // // 남은 동전 횟수들을 공평하게 나눈다.
   // int split = count / 2;
   // count -= div;
   // p1 += coin * (split + count % 2);
   // p2 += coin * split;
   // }
   // System.out.println(p1 == p2 ? 1 : 0);
   // }
   // }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < 3; i++) {
         N = Integer.parseInt(br.readLine());
         int coin[][] = new int[N][2];
         int sum = 0;
         for (int j = 0; j < N; j++) {
            coin[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sum += coin[j][0] * coin[j][1];
         }
         if (sum % 2 == 1) {
            System.out.println(0);
            continue;
         }

         boolean[] dp = new boolean[sum / 2 + 1];
         dp[0] = true;
         // 코인 하나씩 꺼내서 dp 시작
         for (int j = 0; j < N; j++) {
            int price = coin[j][0];
            int count = coin[j][1];
            for (int k = sum / 2; k >= 0; k--) {
               if (!dp[k]) {
                  continue;
               }
               for (int k2 = 1; k2 <= count; k2++) {
                  if (k + price * k2 > sum / 2)
                     break;
                  dp[k + price * k2] = true;
               }
            }
            if (dp[sum / 2]) {
               break;
            }
         }
         System.out.println(dp[sum / 2] ? 1 : 0);
      }
   }
}