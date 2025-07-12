import java.io.*;
import java.util.*;

public class Main {
    static int n, k, l;
    static int[][] map;
    static boolean[][] visited; // visited: 뱀의 몸통의 위치 확인용
    static Queue<String[]> moves = new LinkedList<>();
    static Deque<int[]> snake = new LinkedList<>();
    static int[] dx = { 0, 0, -1, 1 };// 왼쪽, 오른쪽, 위, 아래
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws Exception {
        input();
        snake.offer(new int[] { 1, 1 });
        visited[1][1] = true;

        String[] move = moves.poll();
        int time = 0;
        int direction = 1;
        while (true) {
            int[] head = snake.peek();
            int x = head[0];
            int y = head[1];
            time++;

            x += dx[direction];
            y += dy[direction];
            if (x <= 0 || x > n || y <= 0 || y > n) { // 보드를 벗어나면
                break;
            } else if (visited[x][y]) { // 몸에 닿는다면
                break;
            } else {
                if (map[x][y] == 0) { // 사과가 없다면 몸 길이를 줄인다.
                    int[] tail = snake.pollLast();
                    visited[tail[0]][tail[1]] = false;
                }
                map[x][y] = 0;
                visited[x][y] = true;
                snake.offerFirst(new int[] { x, y });
            }

            if (time == Integer.parseInt(move[0])) {
                direction = changeDirection(direction, move[1]);
                if (!moves.isEmpty())
                    move = moves.poll();
            }
        }
        System.out.println(time);
    }

    private static int changeDirection(int direction, String string) {
        if (direction == 0) {
            if (string.equals("L"))
                return 3;
            return 2;
        } else if (direction == 1) {
            if (string.equals("L"))
                return 2;
            return 3;
        } else if (direction == 2) {
            if (string.equals("L"))
                return 0;
            return 1;
        } else {
            if (string.equals("L"))
                return 1;
            return 0;
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            moves.add(new String[] { st.nextToken(), st.nextToken() });
        }
    }
}