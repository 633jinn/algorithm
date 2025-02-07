import java.io.*;
import java.util.*;

public class Main {
    static int N; // 보드의 길이
    static int K; // 사과의 개수
    static int L; // 방향 전환 횟수
    static int[][] arr;
    static int[] moveX = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
    static int[] moveY = { 0, 0, -1, 1 };
    static int[] leftIndex = { 2, 3, 1, 0 };
    static int[] rightIndex = { 3, 2, 0, 1 };

    static int result = 0;

    static Queue<Move> queue = new LinkedList<>();
    // Deque를 이용한 뱀 머리, 꼬리 구현
    static Deque<Position<Integer, Integer>> deque = new LinkedList<>();

    public static class Position<X, Y> {
        X x;
        Y y;

        public Position(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Move {
        int seconds;
        String turn;

        public Move(int seconds, String turn) {
            this.seconds = seconds;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Move(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        deque.offerLast(new Position<Integer, Integer>(1, 1));
        deque.offerLast(new Position<Integer, Integer>(1, 0));

        moveSnake();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void moveSnake() {
        Position<Integer, Integer> position = deque.peekFirst();
        int x = position.x;
        int y = position.y;
        int turn = 3;
        Move move = queue.poll();

        while (true) {
            result++;
            // 뱀 머리 이동
            x += moveX[turn];
            y += moveY[turn];
            
            // 뱀이 벽에 부딪혔을 때때
            if (!(x > 0 && x <= N && y > 0 && y <= N)) {
                break;
            }
            
            // 사과가 있을 때 뱀 이동
            if (arr[x][y] == 0) {
                deque.pollLast();
            } else {
                arr[x][y] = 0;
            }

            // 뱀이 몸에 부딪혔을 때
            if (checkVisit(x, y)) {
                break;
            }

            position = new Position<Integer, Integer>(x, y);
            deque.offerFirst(position);

            // 방향전환
            if (move != null && move.seconds == result) {
                if (move.turn.equals("L")) {
                    turn = leftIndex[turn];
                }
                if (move.turn.equals("D")) {
                    turn = rightIndex[turn];
                }
                move = queue.poll();
            }
        }
    }

    private static boolean checkVisit(int x, int y) {
        for (Position<Integer, Integer> position : deque) {
            if (position.x.equals(x) && position.y.equals(y)) {
                return true;
            }
        }
        return false;
    }
}