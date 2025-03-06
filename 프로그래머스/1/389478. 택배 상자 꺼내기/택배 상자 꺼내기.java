import java.io.*;
import java.util.*;

class Solution {
    static List<Deque<Integer>> list = new ArrayList<>();
    static int listIdx;
    static int idx;
    public int solution(int n, int w, int num) {
        
        for(int i =0;i<w;i++){
            Deque<Integer> stack = new LinkedList<>();
            list.add(stack);
        }
        int index = 0;
        int addNum = 1;
        if(w==1){
            return n-num+1;
        }
        for(int i=1;i<n+1;i++){
            
            list.get(index).offer(i);
            if(i == num){
                listIdx = index;
                idx = list.get(index).size();
            }  
            
            index += addNum;
            if(addNum == 0){
                if(index == w-1){
                    addNum = -1;
                }else{
                    addNum = 1;
                }
            }else if(index == 0 || index == w-1){
                addNum=0;
            }
        }
        return list.get(listIdx).size() - idx+1;
    }
}