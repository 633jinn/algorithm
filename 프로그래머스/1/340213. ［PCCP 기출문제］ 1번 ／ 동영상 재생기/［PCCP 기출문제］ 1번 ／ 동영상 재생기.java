import java.util.*;
class Solution {
    static int[] time = new int[2];
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] video = new int[2];
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        setTime(pos, op_start, op_end, video_len);
        checkOp();
        for(int i = 0; i<commands.length;i++){
            if(commands[i].equals("next")){
                time[1] += 10;
            }else{
                time[1] -= 10;
            }
            
            if(time[1]<0){
                if(time[0]==0){
                    time[1] = 0;
                }else{
                    time[0]-=1;
                    time[1] += 60;
                }
            }else if(time[1]>=60){
                time[0]+=1;
                time[1] -= 60;
            }
            checkOp();
        }
        String hour = time[0]<=9?"0"+Integer.toString(time[0]):Integer.toString(time[0]);
        String minute = time[1]<=9?"0"+Integer.toString(time[1]):Integer.toString(time[1]);
        String answer = hour+":"+minute;
        return answer;
    }
    public void setTime(String post, String op_start, String op_end, String video_len){
        time = Arrays.stream(post.split(":")).mapToInt(Integer::parseInt).toArray();
        
        start = Arrays.stream(op_start.split(":")).mapToInt(Integer::parseInt).toArray();
        end = Arrays.stream(op_end.split(":")).mapToInt(Integer::parseInt).toArray();
        video = Arrays.stream(video_len.split(":")).mapToInt(Integer::parseInt).toArray();
    }
    
    public void checkOp(){
        if(time[0]*60+time[1]>=start[0]*60+start[1]){
            if(time[0]*60+time[1]<end[0]*60+end[1]){
                time[0] = end[0];
                time[1] = end[1];
            }
        }
        if(time[0]*60+time[1]>video[0]*60+video[1]){
                time[0] = video[0];
                time[1] = video[1];   
        }
    }
}