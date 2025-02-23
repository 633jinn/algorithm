import java.io.*;
import java.util.*;
class Solution {
    List<Schedule> list = new ArrayList();
    public class Schedule{
        int lastTime;
        public Schedule(int lastTime){
            this.lastTime = lastTime;
        }
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        setScheules(schedules);
        
        int result = 0;
        
        for(int i = 0; i<schedules.length;i++){
            int day = startday;
            Schedule s = list.get(i);
            int count = 0;
            for(int j = 0;j<7;j++){
                if(day>=1 && day<=5){                    
                    if(!(timelogs[i][j]<=s.lastTime)){
                        continue;
                    }
                }
                count++;
                //요일 바꾸기
                if(day == 7){
                    day = 1;
                } else{
                    day++;
                }
            }
            
            //토, 일을 제외하고 모두 정상 출근 하였을 경우 +1;
            if(count==7){
                result++;   
            }
        }
        
    
        return result;
    }
    public void setScheules(int[] schedules){
        for(int i = 0; i<schedules.length; i++){
            int hour = schedules[i]/100;
            int minutes = schedules[i]%100+10;
            
            if(minutes>=60){
                hour += 1;
                minutes-= 60;
            }
            int lastTime = hour*100+minutes;
            list.add(new Schedule(lastTime));
        }
    }
}