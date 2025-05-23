import java.io.*;
import java.util.*;

public class Main {
    static int N, K, result = 0;
    static List<String> newWords = new ArrayList<>();
    static List<String> words = new ArrayList<>(Arrays.asList("a", "c", "n", "t", "i"));
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {
        input();
        if (K < 5) {
            System.out.println(0);
            return;
        }

        for (String c : words) {
            visited[c.charAt(0) - 'a'] = true;
        }

        dfs(0, 0);
        System.out.println(result);
        return;
    }

    private static void dfs(int index, int depth) {
        if (depth == K - 5) {
            int count = 0;
            for (String string : newWords) {
                boolean flag = true;
                for (int i = 0; i < string.length(); i++) {
                    if (!visited[string.charAt(i) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            result = Integer.max(result, count);
            return;
        }
        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void input() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.substring(4, str.length() - 4);
            newWords.add(str);
        }
    }
}
