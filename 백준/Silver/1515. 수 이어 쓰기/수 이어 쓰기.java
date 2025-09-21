import java.io.*;
import java.util.*;

public class Main {
   static String string;
   static int length;
   static int compareN;

   public static void main(String[] args) throws Exception {
      input();
      int s_idx = 0;
      int value = 1;
      while (s_idx < length) {
         String temp = String.valueOf(value);
         for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == string.charAt(s_idx)) {
               s_idx++;
            }
            if (s_idx == length) {
               System.out.println(value);
               return;
            }
         }
         value++;
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      string = br.readLine();
      length = string.length();
   }
}