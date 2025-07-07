import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        boolean[] rslt = new boolean[K];
        int count = 0;
        for (int i = 0; i < K; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] adj = new ArrayList[V + 1];
            boolean[] visited = new boolean[V + 1];
            int[] color = new int[V + 1];

            for (int j = 1; j < V + 1; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }

            for (int j = 1; j < V+1; j++) {
                if (!visited[j]) {
                    bfs(adj, visited, color, rslt, count, j);
                }
                if (rslt[count]) break;
            }
            count++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println((rslt[i] ? "NO" : "YES"));
        }
    }

    public static void bfs(ArrayList<Integer>[] adj, boolean[] visited, int[] color, boolean[] rslt, int count, int j) {
        Queue<Integer> q = new LinkedList<>();
        visited[j] = true;
        color[j] = 1;
        q.offer(j);

        while (!q.isEmpty()) {
            int k = q.poll();

            for (int c : adj[k]) {
                if (!visited[c]) {
                    if (color[c] == 0) {
                        if (color[k] == 1) {
                            color[c] = 2;
                            visited[c] = true;
                            q.offer(c);
                        }
                        if (color[k] == 2) {
                            color[c] = 1;
                            visited[c] = true;
                            q.offer(c);
                        }
                    }
                }
                if (color[c] == 1 && color[k] == 1) {
                    rslt[count] = true;
                    return;
                }
                if (color[c] == 2 && color[k] == 2) {
                    rslt[count] = true;
                    return;
                }

        }
         }
    }
}