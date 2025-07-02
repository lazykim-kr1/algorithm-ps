import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        int[][] list = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                list[i][j] = str.charAt(j) - '0';
            }
        }
        boolean[][][] visited =  new boolean[N][M][2];
        int[][][] dist = new  int[N][M][2];

        bfs(visited, dist, list, N, M);

        int rslt = Integer.MAX_VALUE;
        if (dist[N-1][M-1][0] != 0) rslt = Math.min(rslt, dist[N-1][M-1][0]);
        if (dist[N-1][M-1][1] != 0) rslt = Math.min(rslt, dist[N-1][M-1][1]);

        System.out.println(rslt == Integer.MAX_VALUE ? -1 : rslt);


        sc.close();
        
    }
    public static void bfs(boolean[][][] visited, int[][][] dist, int[][] list, int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0][0] = true;
        dist[0][0][0] = 1;
        q.offer(new int[] {0, 0, 0});

        while (!q.isEmpty()) {
            int[] k = q.poll();
            if (k[0] == N-1 && k[1] == M-1) {
                list[N-1][M-1] = -1;
            }

            if (k[0] - 1 >= 0) {
                if (list[k[0] - 1][k[1]] == 0 && !visited[k[0] - 1][k[1]][k[2]]) {
                    visited[k[0] - 1][k[1]][k[2]] = true;
                    dist[k[0] - 1][k[1]][k[2]] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[]{k[0] - 1, k[1], k[2]});
                } else if (list[k[0] - 1][k[1]] == 1 && k[2] == 0 && !visited[k[0] - 1][k[1]][1]) {
                    visited[k[0] - 1][k[1]][1] = true;
                    dist[k[0] - 1][k[1]][1] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[]{k[0] - 1, k[1], 1});
                }
            }
            if (k[0] + 1 < N) {
                if (list[k[0] + 1][k[1]] == 0  && !visited[k[0] + 1][k[1]][k[2]]) {
                    visited[k[0]+1][k[1]][k[2]] = true;
                    dist[k[0]+1][k[1]][k[2]] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0]+1, k[1], k[2]});
                } else if (list[k[0]+1][k[1]] == 1 && k[2] == 0 && !visited[k[0] + 1][k[1]][1]) {
                    visited[k[0]+1][k[1]][1] = true;
                    dist[k[0]+1][k[1]][1] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0]+1, k[1], 1});
                }
            }

            if (k[1] - 1 >= 0) {
                if (list[k[0]][k[1] - 1] == 0 && !visited[k[0]][k[1] - 1][k[2]]) {
                    visited[k[0]][k[1] - 1][k[2]] = true;
                    dist[k[0]][k[1] - 1][k[2]] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0], k[1]-1, k[2]});
                } else if (list[k[0]][k[1]-1] == 1 && k[2] == 0 && !visited[k[0]][k[1] - 1][1]) {
                    visited[k[0]][k[1]-1][1] = true;
                    dist[k[0]][k[1]-1][1] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0], k[1]-1, 1});
                }
            }

            if (k[1] + 1 < M) {
                if (list[k[0]][k[1] + 1] == 0 && !visited[k[0]][k[1] + 1][k[2]]) {
                    visited[k[0]][k[1] + 1][k[2]] = true;
                    dist[k[0]][k[1] + 1][k[2]] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0], k[1]+1, k[2]});
                } else if (list[k[0]][k[1]+1] == 1 && k[2] == 0 && !visited[k[0]][k[1] + 1][1]) {
                    visited[k[0]][k[1]+1][1] = true;
                    dist[k[0]][k[1]+1][1] = dist[k[0]][k[1]][k[2]] + 1;
                    q.offer(new int[] {k[0], k[1]+1, 1});
                }
            }
        }
    }
}
