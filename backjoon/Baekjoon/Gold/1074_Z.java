package java_folder;

import java.io.*;
import java.util.StringTokenizer;

public class Z_1074 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        bw.write(setArray(n, r, c) + "\n");
        bw.flush();
        bw.close();
    }
    public static long setArray(int n, long row, long column) {
        if (n == 1) {
            return row==1? column+2: column;
        }
        long nSquare = (long) Math.pow(2, n)/2;
        long addNum = 0;
        if (row >= nSquare) {
            row -= nSquare;
            addNum += (long) Math.pow(2, 2 * n - 1);
        }
        if (column >= nSquare) {
            column-=nSquare;
            addNum+=(long) Math.pow(2, 2 * n - 2);
        }
        return setArray(n - 1,row, column) + addNum;
    }
}
