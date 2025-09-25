import java.io.*;
import java.util.*;

public class Main {
   static String str;
   static int count_b = 0;
   static int[] arr;
   static int index = 0;

   public static void main(String[] args) throws Exception {
      input();
      for (int i = 0; i < count_b; i++) {
         if (str.charAt(i) == 'b') {
            arr[0]++;
         }
      }
      int maxCount = arr[0];
      for (int i = 1; i < str.length(); i++) {
         arr[i] = arr[i - 1];
         int idxR = i + count_b - 1 < str.length() ? i + count_b - 1 : i + count_b - 1 - str.length();
         int idxL = i - 1 >= 0 ? i - 1 : str.length() - (i - 1);
         if (str.charAt(idxR) == 'b') {
            arr[i]++;
         }
         if (str.charAt(idxL) == 'b') {
            arr[i]--;
         }
         if (maxCount < arr[i]) {
            maxCount = arr[i];
            index = i;
         }
      }
      System.out.println(count_b - maxCount);
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      str = br.readLine();
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) == 'b') {
            count_b++;
         }
      }
      arr = new int[str.length()];
   }
}