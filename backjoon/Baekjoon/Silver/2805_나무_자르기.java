package java_folder;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 나무_자르기_2805 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> trees = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        HashMap<Integer, Integer> treeMap = setHashMap(trees);
        bw.write(binarySearch(treeMap, M) + "\n");
        bw.flush();
        bw.close();
    }

    private static HashMap<Integer, Integer> setHashMap(List<Integer> trees) {
        HashMap<Integer, Integer> treeMap = new HashMap<>();
        for (Integer tree : trees) {
            if (treeMap.containsKey(tree)) {
                treeMap.replace(tree, treeMap.get(tree) + 1);
            } else {
                treeMap.put(tree, 1);
            }
        }
        return treeMap;
    }

    public static int binarySearch(HashMap<Integer, Integer> treeMap, int M) {
        int start = 0;

        List<Integer> treeType = new ArrayList<>(treeMap.keySet());
        Collections.sort(treeType);

        int end = Collections.max(treeType);
        int mid = 0;
        int result = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0; /** int형으로 할경우 오버플로우되어 음수로 변할 가능성이 있다.**/

            for (int type : treeType) {
                if (type > mid) {
                    sum += (long) treeMap.get(type) * (type - mid);
                }
            }
            if (sum >= M) {
                result = mid;
                start = mid + 1;
            }
            if (sum < M) {
                end = mid-1;
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
