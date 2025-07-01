import java.io.*;
import java.util.*;

public class Main {
    static int[] coin = { 500, 100, 50, 10, 5, 1 };
    static int count = 0;
    static int money;

    public static void main(String[] args) throws Exception {
        input();
        int idx = 0;
        while (idx <= 5) {
            if (coin[idx] <= money) {
                money -= coin[idx];
                count++;
            } else {
                idx++;
            }
        }
        System.out.println(count);
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = 1000 - Integer.parseInt(br.readLine()); // 유저의 수
    }
}