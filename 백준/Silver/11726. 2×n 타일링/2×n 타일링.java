import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        input();
        long[] solution = new long[n + 1];
        solution[0] = 1;
        solution[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            solution[i] = (solution[i - 1] + solution[i - 2]) % 10007;
        }
        System.out.println(solution[n]);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}
