import java.util.*;


public class p2252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            adj[A].add(B);
        }

        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                dfs(adj, visited, s, i);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(s.pop() + " ");
        }

    }

    public static void dfs(ArrayList<Integer>[] adj, boolean[] visited, Deque<Integer> s, int v) {
        visited[v] = true;
        for (int w : adj[v]) {
            if (!visited[w]) {
                dfs(adj, visited, s, w);
            }
        }
        s.push(v);
    }
}
