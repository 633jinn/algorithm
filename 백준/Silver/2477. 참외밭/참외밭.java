import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static List<int[]> list = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer direction = Integer.parseInt(st.nextToken());
            Integer length = Integer.parseInt(st.nextToken());

            list.add(new int[] { direction, length });
            map.putIfAbsent(direction, new ArrayList<>());
            map.get(direction).add(length);
        }
        List<Integer> fullIndex = new ArrayList<>();
        List<Integer> splitIndex = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int idx = list.get(i)[0];
            if (map.get(idx).size() == 2) {
                splitIndex.add(idx);
            } else {
                fullIndex.add(idx);
            }
        }
        // 시작 위치에 따라 계산 다르게
        int startIdx = list.get(0)[0];
        int square = map.get(fullIndex.get(0)).get(0) * map.get(fullIndex.get(1)).get(0);
        if (fullIndex.contains(startIdx)) {
            answer = square
                    - map.get(splitIndex.get(0)).get(1) * map.get(splitIndex.get(1)).get(0);
        } else {
            if (startIdx == list.get(2)[0]) {
                if (splitIndex.contains(list.get(3)[0])) {
                    answer = square
                            - map.get(splitIndex.get(0)).get(1) * map.get(splitIndex.get(1)).get(0);
                } else {
                    answer = square - map.get(splitIndex.get(0)).get(0) * map.get(splitIndex.get(1)).get(0);
                }
            } else {
                if (splitIndex.contains(list.get(1)[0])) {
                    answer = square - map.get(splitIndex.get(0)).get(0) * map.get(splitIndex.get(1)).get(1);
                } else {
                    answer = square - map.get(splitIndex.get(0)).get(1) * map.get(splitIndex.get(1)).get(1);
                }
            }
        }

        bw.write(answer * K + "\n");
        bw.flush();
        bw.close();
    }
}