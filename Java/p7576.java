import java.util.*;

public class p7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        ArrayList<int[]> start = new ArrayList<>();

        int[][] list = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                list[i][j] = sc.nextInt();
                if (list[i][j] == 1) start.add(new int[] {i, j});
            }
        }
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        bfs(start, visited, dist, list, N, M);

        int max = dist[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[i][j] > max) max = dist[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list[i][j] == 0) {
                    System.out.println(-1);
                    sc.close();
                    return;
                }
            }
        }
        System.out.println(max);
        sc.close();

    }

    public static void bfs(ArrayList<int[]> start, boolean[][] visited, int[][] dist, int[][] list, int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < start.size(); i++) {
            q.offer(start.get(i));
            visited[start.get(i)[0]][start.get(i)[1]] = true;
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();

            if (point[0]+1 < N && list[point[0]+1][point[1]] == 0 && !visited[point[0]+1][point[1]]) {
                visited[point[0]+1][point[1]] = true;
                dist[point[0]+1][point[1]] = dist[point[0]][point[1]] + 1;
                list[point[0]+1][point[1]] = 1;
                q.offer(new int[] {point[0]+1, point[1]});
            }
            if (point[0]-1 >= 0 && list[point[0]-1][point[1]] == 0 && !visited[point[0]-1][point[1]]) {
                visited[point[0]-1][point[1]] = true;
                dist[point[0]-1][point[1]] = dist[point[0]][point[1]] + 1;
                list[point[0]-1][point[1]] = 1;
                q.offer(new int[] {point[0]-1, point[1]});
            }
            if (point[1] + 1 < M && list[point[0]][point[1]+1] == 0 && !visited[point[0]][point[1]+1]) {
                visited[point[0]][point[1]+1] = true;
                dist[point[0]][point[1]+1] = dist[point[0]][point[1]] + 1;
                list[point[0]][point[1]+1] = 1;
                q.offer(new int[] {point[0], point[1]+1});
            }
            if (point[1] - 1 >= 0 && list[point[0]][point[1]-1] == 0 && !visited[point[0]][point[1]-1]) {
                visited[point[0]][point[1]-1] = true;
                dist[point[0]][point[1]-1] = dist[point[0]][point[1]] + 1;
                list[point[0]][point[1]-1] = 1;
                q.offer(new int[] {point[0], point[1]-1});
            }
        }
    }
}
