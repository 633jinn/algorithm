import java.io.*;
import java.util.*;

/**
 * 모든 노드에서 모든 노드로 가는 최단 경로 구하기 = 플로이드 와샬
 */
public class Main {
    static int n, result = Integer.MAX_VALUE;
    static int[][] w, cost;

    public static void main(String[] args) throws Exception {
        input();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> nodes = new ArrayList<>();
            nodes.add(i);
            backTracking(0, 0, nodes, 0);
        }
        System.out.println(result);
    }

    private static void backTracking(int firstNode, int idx, ArrayList<Integer> nodes, int cost) {
        int node = nodes.get(idx);
        if (nodes.size() == n) {
            if (w[nodes.get(idx)][firstNode] == 0) {
                return;
            }
            result = Math.min(result, cost + w[nodes.get(idx)][firstNode]);
            return;
        }
        // 이동 가능한 노드 찾기
        for (int i = 0; i < n; i++) {
            if (w[node][i] == 0) { // 갈 수 없는 경우면 pass
                continue;
            }
            boolean flag = true;
            for (int j = 0; j <= idx; j++) {
                if ((nodes.size() != n && firstNode == i) || (nodes.get(j) == i && firstNode != i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                nodes.add(i);
                backTracking(firstNode, idx + 1, nodes, cost + w[node][i]);
                nodes.remove(nodes.size() - 1);
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}