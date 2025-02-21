import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {        
        String[] newNumbers = Arrays.stream(numbers)
                                    .boxed()
                                    .map(i -> Integer.toString(i))
                                    .toArray(String[]::new);
        
        Arrays.sort(newNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2; // "62"
                String order2 = o2 + o1; // "26"

                // 더 큰 값을 앞에 두도록 내림차순 정렬
                return order2.compareTo(order1);
            }  
        });
        
        if(Arrays.stream(newNumbers).allMatch(n -> n.equals("0"))){
            return "0";
        }
        
        StringBuilder builder = new StringBuilder();
        for(String num:newNumbers){
            builder.append(num);
        }
        
        
        return builder.toString();
    }
}