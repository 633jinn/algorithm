import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
   static int r, c, k;
   static int[][] arr = new int[100][100];
   static int rowLength = 3, columnLength = 3;
   static int time = 0;

   public static void main(String[] args) throws Exception {
      input();
      while (time < 100 && arr[r][c] != k) {
         if (rowLength >= columnLength) {
            R();
         } else {
            C();
         }
         time++;
      }
      if (arr[r][c] != k)
         System.out.println(-1);
      else
         System.out.println(time);

   }

   private static void R() {
      // 각 행마다 존재하는 원소 갯수 추가하기 위한 용도.
      List<HashMap<Integer, Integer>> mapList = new ArrayList<>(rowLength);
      int maxSize = 0;
      for (int i = 0; i < rowLength; i++) {
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int j = 0; j < columnLength; j++) {
            int key = arr[i][j];
            if (key == 0) {
               continue;
            }
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
         }
         mapList.add(map);
         maxSize = Math.max(maxSize, map.size());
      }
      maxSize = Math.min(maxSize * 2, 100);
      for (int i = 0; i < rowLength; i++) {// 콜럼 기준
         HashMap<Integer, Integer> map = mapList.get(i);
         List<Entry<Integer, Integer>> sortMap = new ArrayList<>(map.entrySet());
         sortMap.sort((e1, e2) -> {
            int cmp = e1.getValue().compareTo(e2.getValue()); // value 오름차순
            if (cmp == 0) {
               return e1.getKey().compareTo(e2.getKey()); // 같으면 key 오름차순
            }
            return cmp;
         });
         for (int j = 0; j < maxSize; j += 2) {
            if (sortMap.size() <= j / 2) {
               arr[i][j] = 0;
               arr[i][j + 1] = 0;
            } else {
               arr[i][j] = sortMap.get(j / 2).getKey();
               arr[i][j + 1] = sortMap.get(j / 2).getValue();
            }
         }
         for (int j = maxSize; j < columnLength; j++) {
            arr[i][j] = 0;
         }
      }
      columnLength = maxSize;
   }

   private static void C() {
      // 각 행마다 존재하는 원소 갯수 추가하기 위한 용도.
      List<HashMap<Integer, Integer>> mapList = new ArrayList<>(columnLength);
      int maxSize = 0;
      for (int i = 0; i < columnLength; i++) {
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int j = 0; j < rowLength; j++) {
            int key = arr[j][i];
            if (key == 0) {
               continue;
            }
            map.putIfAbsent(key, 0);
            map.put(key, map.get(key) + 1);
         }
         mapList.add(map);
         maxSize = Math.max(maxSize, map.size());
      }
      maxSize = Math.min(maxSize * 2, 100);
      for (int i = 0; i < columnLength; i++) {// row 기준
         HashMap<Integer, Integer> map = mapList.get(i);
         List<Entry<Integer, Integer>> sortMap = new ArrayList<>(map.entrySet());
         sortMap.sort((e1, e2) -> {
            int cmp = e1.getValue().compareTo(e2.getValue()); // value 오름차순
            if (cmp == 0) {
               return e1.getKey().compareTo(e2.getKey()); // 같으면 key 오름차순
            }
            return cmp;
         });
         for (int j = 0; j < maxSize; j += 2) {
            if (sortMap.size() <= j / 2) {
               arr[j][i] = 0;
               arr[j + 1][i] = 0;
            } else {
               arr[j][i] = sortMap.get(j / 2).getKey();
               arr[j + 1][i] = sortMap.get(j / 2).getValue();
            }
         }
         for (int j = maxSize; j < rowLength; j++) {
            arr[j][i] = 0;
         }
      }
      rowLength = maxSize;
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      r = Integer.parseInt(st.nextToken()) - 1;
      c = Integer.parseInt(st.nextToken()) - 1;
      k = Integer.parseInt(st.nextToken());

      for (int i = 0; i < 3; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 3; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }
   }
}