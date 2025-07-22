import java.util.*;

class Solution {
    public String solution(String new_id) {
        String s = "~!@#$%^&*()=+[{]}:?,<>/";
        
        boolean oneDot = false;
        StringBuilder sb = new StringBuilder();
        
        
        //1단계
        for(int i = 0; i<new_id.length() ;i++){
            char c = new_id.charAt(i);
            if(c>='A' && c<='Z')
                sb.append(Character.toLowerCase(c));
            else
                sb.append(c);
        }
        
        new_id = sb.toString();
        sb = new StringBuilder();
        //2단계
        for(int i = 0; i<new_id.length() ;i++){
            char c = new_id.charAt(i);
            if(!s.contains(Character.toString(c))){
                sb.append(c);
            }
        }
        boolean flag = false;
        new_id = sb.toString();
        sb = new StringBuilder();
        //3단계
        for(int i = 0; i<new_id.length() ;i++){
            char c = new_id.charAt(i);
            if(flag){
                if(c == '.'){
                    continue;
                }else{
                    
                flag = false;
                }
            }else if(c == '.'){
                flag = true;
            }
            
            sb.append(c);
        }
        
        
        int startIdx = 0;
        int endIdx = sb.length()-1;
        new_id = sb.toString();
        System.out.println(new_id);
        //4단계
        for(int i = 0; i<new_id.length() ;i++){
            char c = new_id.charAt(i);
            if(c != '.'){
                startIdx = i;
                break;
            }
        }
        
       // 맨 마지막 . 제거
        for(int i = endIdx; i>=0 ; i--){
            char c = new_id.charAt(i);
            if(c!= '.' ) {
               endIdx = i;
               break;
           }
        }
        while(endIdx>=0){
            
            char c = new_id.charAt(endIdx);
            if(c == '.' ) {
               endIdx--;
           }else{
                break;
            }
        }
        
        System.out.println(startIdx);
        System.out.println(endIdx);
        if(startIdx > endIdx)
            new_id = "";
        else
            new_id = new_id.substring(startIdx, endIdx+1);
        
        System.out.println(new_id);
        //5단계
        if(new_id.length()==0) new_id = "a";
        
        System.out.println(new_id);
        //6단계
        if(new_id.length()>=16) new_id = new_id.substring(0, 15);
        
        // 맨 마지막 . 제거
        startIdx = 0;
        endIdx = new_id.length()-1;
        for(int i = endIdx; i>=0 ; i--){
            char c = new_id.charAt(i);
            if(c!= '.') {
               endIdx = i;
               break;
           }
        }
        
        
        if(startIdx > endIdx)
            new_id = "";
        else
            new_id = new_id.substring(startIdx, endIdx+1);
        System.out.println(new_id);
        
        //7단계
        sb = new StringBuilder(new_id);
        char lastC = new_id.charAt(new_id.length()-1);
        if(sb.length()<3){
            while(sb.length()!=3){
                sb.append(lastC);
            }
        }
        System.out.println(new_id);
        
        
        
        String answer = "";
        
        
        
        
        return sb.toString();
    }
}