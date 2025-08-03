import java.io.*;
import java.util.*;

/**
 * KMP 알고리즘
 */
public class Main {
   static String[] T, P;
   static ArrayList<ArrayList<Integer>> indexList = new ArrayList<>();
   static Queue<Integer> memory = new LinkedList<>();
   static int count, pi[];

   public static void main(String[] args) throws Exception {
      input();
      pi = new int[P.length];
      getPi();
      String result = kmp();
      System.out.println(count);
      System.out.println(result);
   }

   //
   /**
    * 패턴 일치 저장 배열
    * P를 순회하며 접두사와 접미사가 같은 경우의 길이를 저장한다.
    * P: abacaaba
    * pi: [0, 0, 1, 0, 1, 1, 2, 3]
    */
   private static void getPi() {
      int j = 0;
      for (int i = 1; i < P.length; i++) {

         // 일치하는 문자가 발생했을 때(j>0), 연속적으로 더 일치하지 않으면 j = pi[idx-1]로 돌려준다.

         while (j > 0 && !P[i].equals(P[j])) {
            j = pi[j - 1];
         }

         if (P[i].equals(P[j])) {
            j++;
            pi[i] = j;
         }
      }
   }

   private static String kmp() {
      // 패턴 내 일치체크 index
      int j = 0;
      StringBuilder sb = new StringBuilder();
      // 전체 문자열 돌기
      for (int i = 0; i < T.length; i++) {
         // 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
         while (j > 0 && !T[i].equals(P[j])) {
            j = pi[j - 1];
         }
         // 맞는 경우 패턴의 끝까지 확인했으면 정답
         if (T[i].equals(P[j])) {
            if (j == P.length - 1) {
               count++;
               sb.append(i - P.length + 2 + " ");
               j = pi[j];
            } else {
               j++;
            }
         }
      }
      return sb.toString();
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      T = br.readLine().split("");
      P = br.readLine().split("");
   }
}
