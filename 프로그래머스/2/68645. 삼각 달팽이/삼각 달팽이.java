import java.io.*;
import java.util.*;

class Solution {
    static List<int[]> arr = new ArrayList<>();
    static List<boolean[]> visited = new ArrayList<>();
    static Point[] pointArr;
    public static class Point{
        int left;
        int right;
        boolean visited;
        Point(int left, int right) {
            this.left = left;
            this.right = right;
            this.visited = false;
        }
    }
    
    public int[] solution(int n) {
        
        pointArr = new Point[n];
        for(int i = 0; i < n; i++){
            arr.add(new int[i+1]);
            pointArr[i] = new Point(0,i);
        }
        
        if(n == 1){
            int[] answer = {1};
            return answer;
        }
        
        int top = 0;
        int down = n-1;
        int idx = 0;
        int count = 1;
        boolean horizontal = false; //left = 0, right = 1;
        boolean vertical = false; //down = 0, up = 1;
        while(true){
            if(pointArr[idx].visited || top>down){
                break;
            }
            
            if(!horizontal){
                arr.get(idx)[pointArr[idx].left]=count++;
                pointArr[idx].left = pointArr[idx].left+1;
            }else{
                arr.get(idx)[pointArr[idx].right]=count++;
                pointArr[idx].right = pointArr[idx].right-1;
            }
            if(idx == down){
                if(pointArr[idx].left > pointArr[idx].right){
                    pointArr[idx].visited = true;
                    horizontal = true;
                    down-=1;
                    vertical = true;
                }
                if(!vertical){
                    continue;
                }
            } else if(idx == top){
                if(pointArr[idx].left > pointArr[idx].right){
                    pointArr[idx].visited = true;
                    horizontal = false;
                    vertical = false;
                    top+=1;
                }
            }
            idx = vertical?idx-1:idx+1;
        }
        
        
        int[] answer = new int[n*(n+1)/2];
        int a = 1;
        int row = 1;
        int column = 0;
        for(int i = 1; i<=answer.length;i++){
            answer[i-1] = arr.get(row-1)[column];
            column++;
            if(a == i){
                row++;
                a+=row;
                column = 0;
            }
        }
        
        return answer;
    }
}