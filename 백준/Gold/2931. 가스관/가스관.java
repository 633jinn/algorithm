import java.io.*;
import java.util.*;

public class Main {
   static String[][] arr = new String[25][25];
   static int R, C, total = 0, count = 0;
   static int[] M, Z;
   static Node edge_m, edge_z;
   static int[] movex = { 0, 0, 1, -1 };
   static int[] movey = { 1, -1, 0, 0 };
   static String[][] type = { { "-", "+", "3", "4" }, { "-", "+", "1", "2" }, { "|", "+", "2", "3" },
         { "|", "+", "1", "4" } };// 현재 기준 우,좌,하,상 별 연결될 수 있는 블룩

   static class Node {
      int r;
      int c;
      int dir; // 다음 블록으로 향해야하는 방향
   }

   static Deque<Node> deque = new LinkedList<>();

   public static void main(String[] args) throws Exception {
      input();

      edge_m = findEdge(M);
      edge_z = findEdge(Z);
      String answerb = "";
      if ((edge_m.dir == 0 && edge_z.dir == 3) || (edge_m.dir == 3 && edge_z.dir == 0)) {
         answerb = "4";
      } else if ((edge_m.dir == 2 && edge_z.dir == 0) || (edge_m.dir == 0 && edge_z.dir == 2)) {
         answerb = "3";
      } else if ((edge_m.dir == 1 && edge_z.dir == 2) || (edge_m.dir == 2 && edge_z.dir == 1)) {
         answerb = "2";
      } else if ((edge_m.dir == 3 && edge_z.dir == 1) || (edge_m.dir == 1 && edge_z.dir == 3)) {
         answerb = "1";
      } else if ((edge_m.dir == 0 && edge_z.dir == 1) || (edge_m.dir == 1 && edge_z.dir == 0)
            || (edge_m.dir == 3 && edge_z.dir == 2) || (edge_m.dir == 2 && edge_z.dir == 3)) {
         answerb = edge_m.dir < 2 ? "-" : "|";
      }
      if (count < total) {
         answerb = "+";
      }
      // System.out.println(total);
      // System.out.println(count);
      // System.out.println(edge_m.dir);
      // System.out.println(edge_z.dir);
      System.out.println(String.format("%d %d %s", edge_m.r + 1, edge_m.c + 1, answerb));
   }

   private static Node findEdge(int[] start) {
      Node n = new Node();
      n.r = start[0];
      n.c = start[1];
      for (int i = 0; i < 4; i++) {
         if (n.r + movex[i] < 0 || n.r + movex[i] >= R || n.c + movey[i] < 0 || n.c + movey[i] >= C) {
            continue;
         }
         String block = arr[n.r + movex[i]][n.c + movey[i]];
         if (!block.equals(".") && Arrays.stream(type[i]).anyMatch(b -> b.equals(block))) {
            n.r += movex[i];
            n.c += movey[i];
            n.dir = i;
            count++;
            break;
         }
      }
      while (true) {
         int nextr = n.r + movex[n.dir];
         int nextc = n.c + movey[n.dir];
         String block = arr[n.r][n.c];
         if (Arrays.stream(type[n.dir]).anyMatch(b -> b.equals(block))) {
            if (block.equals("|") || block.equals("+") || block.equals("-")) {
               n.dir = n.dir;
            } else if (block.equals("1")) {// 우,좌,하,상
               nextr = n.dir == 3 ? n.r : n.r + 1;
               nextc = n.dir == 3 ? n.c + 1 : n.c;
               n.dir = n.dir == 3 ? 0 : 2;
            } else if (block.equals("2")) {
               nextr = n.dir == 2 ? n.r : n.r - 1;
               nextc = n.dir == 2 ? n.c + 1 : n.c;
               n.dir = n.dir == 2 ? 0 : 3;
            } else if (block.equals("3")) {
               nextr = n.dir == 2 ? n.r : n.r - 1;
               nextc = n.dir == 2 ? n.c - 1 : n.c;
               n.dir = n.dir == 2 ? 1 : 3;
            } else {
               nextr = n.dir == 3 ? n.r : n.r + 1;
               nextc = n.dir == 3 ? n.c - 1 : n.c;
               n.dir = n.dir == 3 ? 1 : 2;
            }
            n.r = nextr;
            n.c = nextc;
         } else {
            return n;
         }
         count++;
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      R = Integer.parseInt(input[0]);
      C = Integer.parseInt(input[1]);

      for (int i = 0; i < R; i++) {
         String[] s = br.readLine().split("");
         for (int j = 0; j < C; j++) {
            arr[i][j] = s[j];
            if (arr[i][j].equals("M")) {
               M = new int[] { i, j };
            } else if (arr[i][j].equals("Z")) {
               Z = new int[] { i, j };
            } else if (!arr[i][j].equals(".")) {
               total++;
            }
         }
      }
   }
}
