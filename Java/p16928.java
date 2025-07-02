import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] list = new int[101];
        for (int i = 1; i < 101; i++) {
            list[i] = i;
        }
        for (int i = 0; i < N+M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x] = y;
        }
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];

        bfs(list, visited, dist);
        System.out.println(dist[100]);
    }

    public static void bfs(int[] list, boolean[] visited, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(list[1]);

        while (!q.isEmpty()) {
            int k  = q.poll();
            if (k == 100) return;

            if (k+1 <= 100 && !visited[k+1] && !visited[list[k+1]]) {
                visited[k+1] = true;
                visited[list[k+1]] = true;
                dist[list[k+1]] = dist[k] + 1;
                q.offer(list[k+1]);
            }
            if (k+2 <= 100 && !visited[k+2] && !visited[list[k+2]]) {
                visited[k+2] = true;
                visited[list[k+2]] = true;
                dist[list[k+2]] = dist[k] + 1;
                q.offer(list[k+2]);
            }
            if  (k+3 <= 100 && !visited[k+3] && !visited[list[k+3]]) {
                visited[k+3] = true;
                visited[list[k+3]] = true;
                dist[list[k+3]] = dist[k] + 1;
                q.offer(list[k+3]);
            }
            if (k+4 <= 100 && !visited[k+4] && !visited[list[k+4]]) {
                visited[k+4] = true;
                visited[list[k+4]] = true;
                dist[list[k+4]] = dist[k] + 1;
                q.offer(list[k+4]);
            }
            if (k+5 <= 100 && !visited[k+5]  && !visited[list[k+5]]) {
                visited[k+5] = true;
                visited[list[k+5]] = true;
                dist[list[k+5]] = dist[k] + 1;
                q.offer(list[k+5]);
            }
            if  (k+6 <= 100 && !visited[k+6] && !visited[list[k+6]]) {
                visited[k+6] = true;
                visited[list[k+6]] = true;
                dist[list[k+6]] = dist[k] + 1;
                q.offer(list[k+6]);
            }
        }
    }
}
