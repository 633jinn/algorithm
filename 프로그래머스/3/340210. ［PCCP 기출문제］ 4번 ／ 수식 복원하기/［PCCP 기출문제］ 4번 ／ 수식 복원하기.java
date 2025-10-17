import java.util.*;

class Solution {
    static ArrayList<String> guess = new ArrayList<>();
    static ArrayList<String> exp = new ArrayList<>();
    static int g_count = 0; //return 개수
    static ArrayList<Integer> num = new ArrayList<>();
    public String[] solution(String[] expressions) {
        char maxNum = '0';
        for(int i = 0 ; i<expressions.length; i++){
            for(int j = 0; j<expressions[i].length(); j++){
                char c = expressions[i].charAt(j);
                if(!(c>='0' && c<='9')) continue;
                if(maxNum<c) maxNum = c;
            }
            if(expressions[i].contains("X")){
                guess.add(expressions[i]);
                g_count++;
            }else{
                exp.add(expressions[i]);
            }
        }
        for(int i = maxNum-'0'+1; i<=9;i++) num.add(i);
        System.out.println(maxNum);
        System.out.println(num);
        
        //진법 가능성 좁히기
        for(int i = 0; i<exp.size(); i++){
            for(int j = num.size()-1; j>=0; j--){
                String[] split = exp.get(i).split(" ");

                int num1 = Integer.parseInt(split[0], num.get(j));
                int num2 = Integer.parseInt(split[2], num.get(j));
                int num3 = Integer.parseInt(split[4], num.get(j));
                System.out.println(num1);
                System.out.println(num2);
                System.out.println(num3);
                System.out.println("======");
                if(split[1].equals("+") && num1+num2 !=num3) num.remove(j);
                else if(split[1].equals("-") && num1-num2 !=num3) num.remove(j);
            }
        }
        System.out.println(num);
        
        String[] answer = new String[g_count];
        int idx = 0;
        for(String g : guess){
            String[] split = g.split(" ");
            String x = "";
            boolean multiAns = false;
            for(int n: num){
                int num1 = Integer.parseInt(split[0], n);
                int num2 = Integer.parseInt(split[2], n);
                String ans = "";
                if(split[1].equals("+")) ans = Integer.toString(num1+num2, n);
                else ans = Integer.toString(num1-num2, n);
                System.out.println(String.format("ans = %s", ans));
                if(x.equals("")) {x = ans;}
                else if(!x.equals(ans)){
                    multiAns = true;
                    break;
                }
            }
            if(multiAns){
                answer[idx++] = g.replace("X", "?");
            }else{
                answer[idx++] = g.replace("X", x);
            }
        }
        
        
        
        return answer;
    }
}