import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U, D; // 건물 층 수, 강호의 위치, 목적지, 올라가는 층수, 내려가는 층수

    static Deque<Integer> deque = new LinkedList<>();
    static int[] visited; // 눌러야 하는 버튼의 수를 위해 boolean이 아닌 int로 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);

        visited = new int[F + 1];
        Arrays.fill(visited, -1);
        deque.offer(S);
        bfs();

        if (visited[G] == -1) {
            bw.write("use the stairs");
        } else {
            bw.write(String.valueOf(visited[G]));
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        visited[S] = 0;
        while (!deque.isEmpty()) {
            int now = deque.poll();
            if (now == G) {
                return;
            }
            int add = now + U;
            int sub = now - D;
            if (add <= F && visited[add] == -1) {
                visited[add] = visited[now] + 1;
                deque.offer(add);
            }
            if (sub >= 1 && visited[sub] == -1) {
                visited[sub] = visited[now] + 1;
                deque.offer(sub);
            }
        }
    }
}