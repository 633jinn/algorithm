import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int N;
    static String str;
    static List<BigInteger> list = new ArrayList<>();
    static String charToInteger = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            parsing();
        }
        Collections.sort(list);
        for (BigInteger i : list) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void parsing() {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('a' <= c && c <= 'z') {
                if (!charToInteger.equals("")) {
                    // long보다 더 큰 수가 올 수 있기 때문에 java.math의 BigInteger사용
                    list.add(new BigInteger(charToInteger));
                    charToInteger = "";
                }
            } else {
                charToInteger += c;
            }
        }
        if (!charToInteger.equals("")) {
            list.add(new BigInteger(charToInteger));
            charToInteger = "";
        }
    }
}