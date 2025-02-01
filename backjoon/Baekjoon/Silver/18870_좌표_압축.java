package java_folder;

import java.io.*;
import java.util.*;

public class 좌표_압축 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] input = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        //중복 제거를 위해 사용
        // arr.contains를 사용해서 중복 제거시 모두 읽어야하기 떄문에 O(n)의 시간이 걸림
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(stringTokenizer.nextToken());
            input[i] = x;
            hash.add(x);
        }

        // HashSet은 정렬할 수 없음. 따라서 ArrayList로 옮겨주고 sort
        List<Integer> arr = new ArrayList<>(hash);
        //Array.sort보다 Collections.sort가 더 빠르다.
        Collections.sort(arr);

        for (Integer i :
                input) {
            bw.write(findIndex(i, arr) + " ");
        }

        bw.flush();
        bw.close();
    }

    //이분탐색
    public static int findIndex(int x, List<Integer> arr) {
        int start = 0;
        int end = arr.size();
        int mid = (start + end) / 2;
        while (start <= end) {
            mid = (start + end) / 2;
            int midNum = arr.get((start + end) / 2);
            if (midNum == x) {
                break;
            } else if (midNum > x) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return mid;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
