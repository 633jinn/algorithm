import java.util.*;
import java.io.*;

class Solution {
    static int B;
    static int Y;
    static int width;
    static int[] answer = new int[2];
    public int[] solution(int brown, int yellow) {
        B = brown;
        Y = yellow;
        int size = (B-4)/2; //width + height
        
        int width = Y;
        int height = 1;
        while(width >= height){
            if(width + height == size){
                answer[0] = width+2;
                answer[1] = height+2;
                break;
            }
            width -= 1;
            while(Y%width!=0){
                width -=1;   
            }
            height = Y/width;
        }
        return answer;
    }
}