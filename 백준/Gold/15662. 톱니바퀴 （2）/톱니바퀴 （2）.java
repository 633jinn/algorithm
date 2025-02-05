
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[][] wheels = new String[T][8];
        Integer[][] directions = new Integer[T][3];

        for (int i = 0; i < T; i++) {
            wheels[i] = (br.readLine().split(""));
            directions[i] = new Integer[] { 0, 6, 2 }; // 상, 좌, 우 방향 index
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int wheel = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            moveWheels(wheels, directions, wheel-1, direction);
        }
        int result = 0;
        for (int i = 0; i < T; i++) {
            if (wheels[i][directions[i][0]].equals("1")) {
                result += 1;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void moveWheels(String[][] wheels, Integer[][] directions, int wheel, int direction) {
        int oppositDirection = direction == 1 ? -1 : 1;

        if (wheel != 0 && !wheels[wheel][directions[wheel][1]].equals(wheels[wheel - 1][directions[wheel - 1][2]])) {
            moveWheels(wheels, directions, wheel-1, oppositDirection, "left");
        }
        if (wheel < wheels.length - 1
                && !wheels[wheel][directions[wheel][2]].equals(wheels[wheel + 1][directions[wheel + 1][1]])) {
            moveWheels(wheels, directions, wheel+1, oppositDirection, "right");
        }
        changeDirections(directions, wheel, direction);
    }

    private static void moveWheels(String[][] wheels, Integer[][] directions, int wheel, int direction1,
            String direction2) {
        int oppositDirection = direction1 == 1 ? -1 : 1;
        if (direction2.equals("left")) {
            if (wheel != 0 && !wheels[wheel][directions[wheel][1]].equals(wheels[wheel - 1][directions[wheel - 1][2]])) {
                moveWheels(wheels, directions, wheel-1, oppositDirection, "left");
            }
        } else {
            if (wheel < wheels.length - 1
                    && !wheels[wheel][directions[wheel][2]].equals(wheels[wheel + 1][directions[wheel + 1][1]])) {
                moveWheels(wheels, directions, wheel+1, oppositDirection, "right");
            }
        }
        changeDirections(directions, wheel, direction1);
    }

    private static void changeDirections(Integer[][] directions, int wheel, int direction) {
        if (direction == 1) {
            for (int w = 0; w<3; w++) {
                int x = directions[wheel][w];
                directions[wheel][w] = (x == 0) ? 7 : x - 1;
            }
        }
        if (direction == -1) {
            for (int w = 0; w<3; w++) {
                int x = directions[wheel][w];
                directions[wheel][w] = (x == 7) ? 0 : x + 1;
            }
        }
    }
}