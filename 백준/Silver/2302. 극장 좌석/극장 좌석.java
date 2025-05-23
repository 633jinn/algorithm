import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> vips = new ArrayList<>();
    static List<Long> board = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        long result = 1;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!vips.contains(i)) {
                count++;
            } else {
                result *= getBoard(count);
                count = 0;
            }
        }
        if (!vips.contains(N)) {
            result *= getBoard(count);
        }
        System.out.println(result);
    }

    private static long getBoard(int count) {
        int size = board.size();
        if (size - 1 < count) {
            for (int i = size; i <= count; i++) {
                board.add(board.get(i - 1) + board.get(i - 2));
            }
        }
        return board.get(count);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int vip = Integer.parseInt(br.readLine());
            vips.add(vip);
        }
        board.add((long) 1);
        board.add((long) 1);
        board.add((long) 2);
        board.add((long) 3);
    }
}
