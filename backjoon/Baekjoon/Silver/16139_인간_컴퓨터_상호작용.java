package java_folder;

import java.io.*;
import java.util.StringTokenizer;

public class 인간_컴퓨터_상호작용_16139 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        int size = string.length();
        int[][] prefixSum = new int[size][26];
        prefixSum[0][string.charAt(0) - 97] = 1;

        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1].clone();
            int c = string.charAt(i) - 97;
            prefixSum[i][c] += 1;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int answer = prefixSum[r][c - 97];
            if (l != 0) {
                answer -= prefixSum[l - 1][c - 97];
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
