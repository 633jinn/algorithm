import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!list.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int num = list.removeFirst();
                list.addLast(num);
            }
            sb.append(list.removeFirst());
            if (list.isEmpty())
                sb.append(">");
            else
                sb.append(", ");
        }
        System.out.println(sb.toString());
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
    }

}
