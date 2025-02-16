import java.io.*;
import java.util.*;

public class Main {

    /**
     * 연산자들을 순열(Permutaion)을 이용해 정렬한다.
     * 아래의 순열 함수는 재귀를 이용한 백트래킹 방법을 이용했다.
     * 시간복잡도가 O(n!)이기 떄문에 n<=10에 가까워야 한다.
     */

    static int N;
    static List<Integer> numbers;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;

    // 순열을 위한 변수
    static String[] operator = { "+", "-", "*", "/" };
    static List<String> operators = new ArrayList<>();
    static List<String> permutateOperations = new ArrayList<>(); // 연산자들을 순열한 list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N - 1];
        numbers = new ArrayList<>(
                Arrays.asList(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new)));

        setOperators(br.readLine());

        permutation(0, N - 1, N - 1); // (N-1)! 진행

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

    private static void setOperators(String string) {
        StringTokenizer st = new StringTokenizer(string);
        for (int i = 0; i < 4; i++) {
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 0; j < idx; j++) {
                operators.add(operator[i]);
            }
        }
    }

    /**
     * Permutation(nPr)
     * 
     * @param depth 순열의 index로 이용한다.
     * @param n
     * @param r
     */
    private static void permutation(int depth, int n, int r) {
        if (depth == r) {
            calculate();
            return;
        }

        // 0부터 n까지 반복
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 값이면 넣기
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                permutateOperations.add(operators.get(i));
                permutation(depth + 1, n, r); // depth+1 를 전달
                visited[i] = false; // 다음 순열을 뽑기 위해 방문 처리 제거
                permutateOperations.remove(depth); // permutateOperations의 마지막 값 삭제
            }
        }
    }

    private static void calculate() {
        int result = numbers.get(0);

        for (int i = 0; i < N - 1; i++) {
            String operation = permutateOperations.get(i);
            if (operation == "+") {
                result += numbers.get(i + 1);
            } else if (operation == "-") {
                result -= numbers.get(i + 1);
            } else if (operation == "*") {
                result *= numbers.get(i + 1);
            } else if (operation == "/") {
                if (result < 0) {
                    result = Math.abs(result);
                    result /= numbers.get(i + 1);
                    result -= result * 2;
                } else {
                    result /= numbers.get(i + 1);
                }
            }
        }
        if (max < result) {
            max = result;
        }
        if (min > result) {
            min = result;
        }
    }

}