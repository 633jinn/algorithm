import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer value;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    value = Integer.parseInt(st.nextToken());
                    deque.offer(value);
                    break;
                case "pop":
                    value = deque.pollLast();
                    if (value == null)
                        value = -1;
                    System.out.println(value);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    value = deque.isEmpty() ? 1 : 0;
                    System.out.println(value);
                    break;
                case "top":
                    value = deque.peekLast();
                    if (value == null)
                        value = -1;
                    System.out.println(value);
                    break;
            }
        }
    }
}