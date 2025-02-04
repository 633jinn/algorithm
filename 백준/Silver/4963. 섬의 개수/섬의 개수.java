import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            if (width == 0 && height == 0) {
                break;
            }
            String[][] arr = new String[height][width];
            for (int i = 0; i < height; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);// br.readLine().split(" ");
            }
            bw.write(findLand(arr, width, height));
        }
        bw.flush();
        bw.close();
    }

    private static String findLand(String[][] arr, int width, int height) {
        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (arr[i][j].equals("1")) {
                    dfs(arr, i, j, width, height);
                    result += 1;
                }
            }
        }

        return result + "\n";
    }

    private static void dfs(String[][] arr, int x, int y, int width, int height) {
        if(arr[x][y].equals("0")){
            return;
        }
        arr[x][y] = "0";

        if (x > 0) {
            if (y > 0) {
                dfs(arr, x - 1, y - 1, width, height);
                dfs(arr, x, y - 1, width, height);
            }
            if (y < width - 1) {
                dfs(arr, x - 1, y + 1, width, height);
                dfs(arr, x, y + 1, width, height);
            }
            dfs(arr, x - 1, y, width, height);
        }
        if (x < height - 1) {
            if (y > 0) {
                dfs(arr, x + 1, y - 1, width, height);
                dfs(arr, x, y - 1, width, height);
            }
            if (y < width - 1) {
                dfs(arr, x + 1, y + 1, width, height);
                dfs(arr, x, y + 1, width, height);
            }
            dfs(arr, x + 1, y, width, height);
        }
    }
}