import java.util.*;

class Solution {
   static String[] str = { "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
         "s", "t", "u", "v", "w", "x", "y", "z" }; // 26
    List<Long> set = new ArrayList<>();
   public String solution(long n, String[] bans) {
       for(int i = 0; i<bans.length; i++){
           StringBuilder sb = new StringBuilder();
          long num = 0;
           for(int j = 0; j<bans[i].length(); j++){
               num += (bans[i].charAt(j)-'a'+1) * Math.pow(26,(bans[i].length()-1-j));
           }
           set.add(num);
       }
       Collections.sort(set);
       for(long ban: set){
           
           if(ban<=n) n++;
       }
       StringBuilder sb = new StringBuilder();
      while(n>=26){
        long div = n%26;
          if(div == 0){
              div = 26;
              n-=26;
          }
          sb.insert(0, str[(int)div]);
          n/=26;
      }
      sb.insert(0, str[(int)n]);
       
      return sb.toString();
   }
}