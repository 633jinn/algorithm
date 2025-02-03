import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> line = Arrays.stream(br.readLine().split(" "))
                    .map(s -> Integer.parseInt(s)).collect(Collectors.toList());

            List<Integer> first = line.subList(0, 3);
            List<Integer> second = line.subList(3, 6);
            bw.append(findPosition(first, second) + "\n");
        }
        bw.flush();
        bw.close();
    };

    static int findPosition(List<Integer> first, List<Integer> second) {
        ;
        double distance = Math.pow(first.get(0) - second.get(0), 2) + Math.pow(first.get(1) - second.get(1), 2);
        double add = Math.pow(first.get(2) + second.get(2), 2);
        double sub = Math.pow(Math.max(first.get(2), second.get(2)) - Math.min(first.get(2), second.get(2)), 2);

        if (first.equals(second)) {
            return -1;
        }
        if (add == distance || sub == distance) {
            return 1;
        }
        if (add < distance || sub > distance) {
            return 0;
        }
        return 2;
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
