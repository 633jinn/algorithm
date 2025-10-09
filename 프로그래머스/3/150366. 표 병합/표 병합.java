import java.util.*;

/**
1. 값 하나 update
2. value1에 해당하는 모든 값 update
3. 두 위치의 셀 병합(값이 하나일경우 그 값을, 둘 다 있을 경우 첫번째 셀 값으로)
4. 병합 해제 - 값이 존재할 경우 그 값을 가진다.
5. 값 출력, 없을경우 EMPTY
*/

class Solution {
    static class Value{
        String value;
        public Value(String v){
            value = v;
        }
    }
    static HashMap<Value, ArrayList<int[]>> map = new HashMap<>();
    static Value[][] arr = new Value[51][51];
    public String[] solution(String[] commands) {
        setArr();
        List<String> answer = new ArrayList<>();
        for(String command: commands){
            String[] split = command.split(" ");
            switch(split[0]){
                case "UPDATE":
                    if(split.length == 4) 
                        update1(Integer.parseInt(split[1]),Integer.parseInt(split[2]), split[3]);
                    else
                        update2(split[1], split[2]);
                    break;
                case "MERGE":
                    int r1 = Integer.parseInt(split[1]);
                    int c1 = Integer.parseInt(split[2]);
                    int r2 = Integer.parseInt(split[3]);
                    int c2 = Integer.parseInt(split[4]);
                    merge(r1, c1, r2, c2);
                    break;
                case "UNMERGE":
                    unmerge(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    break;
                case "PRINT":
                    String string = print(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                    answer.add(string);
                    break;
            }
        }
        
        return answer.toArray(new String[0]);
    }
    public void setArr(){        
        for(int i = 1; i<=50; i++){
            for(int j = 1; j<=50; j++){
                arr[i][j] = new Value("");
                ArrayList<int[]> list = new ArrayList<>();
                list.add(new int[]{i, j});
                map.put(arr[i][j], list);
            }
        }
    }
    
    public void update1(int r, int c, String v){
        arr[r][c].value = v;
        // System.out.println("UPDATE1:");
        // System.out.println(String.format("[%d][%d]: %s", r, c, arr[r][c].value));
    }
    
    public void update2(String v1, String v2){
        for(Value v: map.keySet()){
            if(v.value.equals(v1)){
                for(int[] node: map.get(v)){
                    arr[node[0]][node[1]].value = v2;
                    
                    // System.out.println("UPDATE2:");
                    // System.out.println(String.format("[%d][%d]: %s", node[0], node[1], arr[node[0]][node[1]].value));
                }
            }
        }
    }
    
    public void merge(int r1, int c1, int r2, int c2){
        Value v1 = arr[r1][c1];
        Value v2 = arr[r2][c2];
        if(v1 == v2) return;
        if(v1.value.equals("") && !v2.value.equals("")){
            ArrayList<int[]> list = map.get(v1);
            for(int[] node: list){
                arr[node[0]][node[1]] = v2;
                map.get(v2).add(new int[]{node[0], node[1]});
            }
            map.remove(v1);
        }
        else{
            ArrayList<int[]> list = map.get(v2);
            for(int[] node: list){
                arr[node[0]][node[1]] = v1;
                map.get(v1).add(new int[]{node[0], node[1]});
            }
            map.remove(v2);
        }
        // System.out.println("MERGE:");
        // System.out.println(String.format("[%d][%d]: %s", r1, c1, arr[r1][c1].value)); 
        // System.out.println(String.format("[%d][%d]: %s", r2, c2, arr[r2][c2].value));
    }
    
    public void unmerge(int r, int c){
        Value v = arr[r][c];
        ArrayList<int[]> list = map.get(v);
        for(int[] node: list){
            if(node[0] == r && node[1] ==c)
                arr[node[0]][node[1]] = new Value(v.value);
            else
                arr[node[0]][node[1]] = new Value("");
            ArrayList<int[]> nlist = new ArrayList<>();
            nlist.add(new int[]{node[0], node[1]});
            map.put(arr[node[0]][node[1]], nlist);
        }
        map.remove(v);
        // System.out.println("UNMERGE:");
        // System.out.println(String.format("[%d][%d]: %s", r, c, arr[r][c].value)); 
    }
    
    public String print(int r, int c){
        Value v = arr[r][c];
        return arr[r][c].value.equals("")?"EMPTY":arr[r][c].value;
    }
}