import java.util.*;

class Solution {
    static int[] arr = new int[10];
    static int[][] time = new int[10][2];
    static ArrayList<String>[] stime = new ArrayList[10];
    static HashMap<String, Integer> map = new HashMap<>();
    public String solution(int n, int t, int m, String[] timetable) {
        for(int i = 0; i<10 ; i++ )
            stime[i] = new ArrayList<>();
        time[0][0] = 9;
        time[0][1] = 0;
        for(int i = 1; i < n ; i++){
            time[i][1] = time[i-1][1]+t;
            if(time[i][1]>=60){
                time[i][0] += time[i][1] / 60;
                time[i][1] = time[i][1] % 60;
            }
            time[i][0] += time[i-1][0];
        }
        int hour = 9;
        int min = 0;
        int idx = 0;
        Arrays.sort(timetable);
        for(int i = 0; i < timetable.length ; i++){
            int hh = Integer.parseInt(timetable[i].substring(0,2));
            int mm = Integer.parseInt(timetable[i].substring(3));
            
            map.put(timetable[i], map.getOrDefault(timetable[i], 0)+1);
            while(idx<n){
                if(arr[idx] == m)
                    idx++;
                else if((hh==time[idx][0] && mm <=time[idx][1]) || hh<time[idx][0]){
                    arr[idx]++;
                    stime[idx].add(timetable[i]);
                    break;
                }else{
                    idx++;
                }
            }
        }
        if(arr[n-1] < m){
            hour = time[n-1][0];
            min = time[n-1][1];
        }else{
            String str = stime[n-1].get(m-1);
            int hh = Integer.parseInt(str.substring(0,2));
            int mm = Integer.parseInt(str.substring(3))-1;
            if(mm < 0){
                mm = 59;
                hh -= 1;
            }
            return String.format("%02d", hh) + ":" + String.format("%02d", mm);       
        }
        
        
        return String.format("%02d", hour) + ":" + String.format("%02d", min);
    }
}