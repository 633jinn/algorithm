package java_folder;

import java.io.*;
import java.util.*;

public class 좌표_정렬하기 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        /**
         *         arr 2차원 기준 첫번째 행(o1)과 두번쨰 행(o2)를 비교,
         *         각 행의 x값이 같으면 y값 기준 오름차순, 다르면 x값 기준 오름차순을 한다.
         */
        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for (int i = 0; i < n; i++) {

            bw.write(Integer.toString(arr[i][0])+ " "+Integer.toString(arr[i][1]) + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}