import java.io.*;
import java.util.*;

public class Main {
    static long X;
    static long Y;
    static long Z;

    static long left, mid, right;

    static long result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = calculate(0);
        if (Z < 99) {
            binarySearch();
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static long calculate(long num) {

        return (Y + num) * 100 / (X + num);
    }

    private static void binarySearch() {
        left = 1;
        right = (int) 1e9; // = 1,000,000,000
        while (left <= right) {
            mid = (left + right) / 2;
            long cal = calculate(mid);

            if (cal != Z) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}