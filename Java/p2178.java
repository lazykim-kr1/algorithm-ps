import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2178 {

	
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
		
		int[][] dist = new int[N][M];
		
		boolean[][] visited = new boolean[N][M];
		
		bfs(visited, list, N, M, dist);
		System.out.println(dist[N-1][M-1]);
		sc.close();
	}
	
	public static void bfs(boolean[][] visited, int[][] list, int N, int M, int dist[][]) {

		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[2]);
		visited[0][0] = true;
		dist[0][0] = 1;
		
		while (!q.isEmpty()) {
			
			int[] k = q.poll();

			
			if (k[0] == N-1 && k[1] == M-1) return;
			
			
			if (k[1] + 1 <= M-1 && list[k[0]][k[1]+1] != 0 && !visited[k[0]][k[1]+1]) {
				visited[k[0]][k[1]+1] = true;
				dist[k[0]][k[1]+1] = dist[k[0]][k[1]] + 1;
				q.offer(new int[] {k[0], k[1]+1});
			}
			if (k[1] - 1 >= 0 && list[k[0]][k[1]-1] != 0 && !visited[k[0]][k[1]-1]) {
				visited[k[0]][k[1]-1] = true;
				dist[k[0]][k[1]-1] = dist[k[0]][k[1]] + 1;
				q.offer(new int[] {k[0], k[1]-1});
				
			}
			if (k[0] - 1 >= 0 && list[k[0]-1][k[1]] != 0 && !visited[k[0]-1][k[1]]) {
				visited[k[0]-1][k[1]] = true;
				dist[k[0]-1][k[1]] = dist[k[0]][k[1]] + 1;
				q.offer(new int[] {k[0]-1, k[1]});
			}
			if (k[0] + 1 <= N-1 && list[k[0]+1][k[1]] != 0 && !visited[k[0]+1][k[1]]) {
				visited[k[0]+1][k[1]] = true;
				dist[k[0]+1][k[1]] = dist[k[0]][k[1]] + 1;
				q.offer(new int[] {k[0]+1, k[1]});
			}

			}
		
	}
	
}
