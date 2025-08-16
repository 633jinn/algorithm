import java.io.*;
import java.util.*;

public class Main {
   static int V, E;
   static List<List<Edges>> graph = new ArrayList<>();
   static boolean[] visited;

   static class Edges {
      int node;
      int cost;

      public Edges(int node, int cost) {
         this.node = node;
         this.cost = cost;
      }
   }

   static PriorityQueue<Edges> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));

   public static void main(String[] args) throws Exception {
      input();
      prim();
   }

   private static void prim() {
      int count = 0;
      int cost = 0;
      pq.offer(new Edges(1, 0));

      while (!pq.isEmpty()) {
         Edges edges = pq.poll();
         if (visited[edges.node])
            continue;

         visited[edges.node] = true;
         cost += edges.cost;
         if (++count == V) {
            System.out.println(cost);
            return;
         }

         for (int i = 0; i < graph.get(edges.node).size(); i++) {
            Edges newEdge = graph.get(edges.node).get(i);
            if (!visited[newEdge.node]) {
               pq.offer(newEdge);
            }
         }
      }
   }

   private static void input() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      visited = new boolean[V + 1];
      for (int i = 0; i < V + 1; i++) {
         graph.add(new ArrayList<>());
      }

      for (int i = 0; i < E; i++) {
         st = new StringTokenizer(br.readLine());
         int first = Integer.parseInt(st.nextToken());
         int second = Integer.parseInt(st.nextToken());
         int cost = Integer.parseInt(st.nextToken());

         graph.get(first).add(new Edges(second, cost));
         graph.get(second).add(new Edges(first, cost));
      }
   }
}
