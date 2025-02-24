import java.io.*;
import java.util.*;

public class Main {
    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < 21; k++) {
                    int one = 1;
                    int two = 1;
                    int three = 1;
                    int four = 1;
                    if (i < j && j < k) {
                        if (!(i <= 0 || j <= 0 || k - 1 <= 0)) {
                            one = arr[i][j][k - 1];
                        }
                        if (!(i <= 0 || (j - 1) <= 0 || k - 1 <= 0)) {
                            two = arr[i][j - 1][k - 1];
                        }
                        if (!(i <= 0 || j - 1 <= 0 || k <= 0)) {
                            three = arr[i][j - 1][k];
                        }
                        arr[i][j][k] = one + two - three;
                        continue;
                    }
                    if (!((i - 1) <= 0 || k <= 0 || j <= 0)) {
                        one = arr[i - 1][j][k];
                    }
                    if (!((i - 1) <= 0 || (j - 1) <= 0 || k <= 0)) {
                        two = arr[i - 1][j - 1][k];
                    }
                    if (!((i - 1) <= 0 || k - 1 <= 0 || j <= 0)) {
                        three = arr[i - 1][j][k - 1];
                    }
                    if (!((i - 1) <= 0 || k - 1 <= 0 || j - 1 <= 0)) {
                        four = arr[i - 1][j - 1][k - 1];
                    }

                    arr[i][j][k] = one + two + three - four;
                }
            }
        }

        while (true) {
            int[] str = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (str[0] == -1 && str[1] == -1 && str[2] == -1) {
                break;
            }
            int result;
            if (str[0] <= 0 || str[1] <= 0 || str[2] <= 0) {
                result = 1;
            } else if (str[0] > 20 || str[1] > 20 || str[2] > 20) {
                result = arr[20][20][20];
            } else {
                result = arr[str[0]][str[1]][str[2]];
            }
            bw.write(String.format("w(%d, %d, %d) = %d", str[0], str[1], str[2], result) + "\n");
        }

        bw.flush();
        bw.close();
    }

}