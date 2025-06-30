import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] rslt = new int[testCase];
		
		for (int i = 0; i < testCase; i++) {
			int l = sc.nextInt();
			int cy = sc.nextInt();
			int cx = sc.nextInt();
			int ty = sc.nextInt();
			int tx = sc.nextInt();
			
			int[][] dist = new int[l][l];
			boolean[][] visited = new boolean[l][l];
			
			bfs(cy, cx, ty, tx, dist, visited, l);
			rslt[i] = dist[ty][tx];
		}
		for (int i : rslt) {
			System.out.println(i);
		}
		sc.close();
	}
	
	public static void bfs(int cy, int cx, int ty, int tx, int[][] dist, boolean[][] visited, int l) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {cy, cx});
		visited[cy][cx] = true;
		dist[cy][cx] = 0;
		
		while (!q.isEmpty()) {
			int[] a = q.poll();
			
			if (a[0] - 2 >= 0 && a[1] - 1 >= 0 && !visited[a[0]-2][a[1]-1]) {
				visited[a[0]-2][a[1]-1] = true;
				dist[a[0]-2][a[1]-1] = dist[a[0]][a[1]] + 1;
				if (a[0]-2 == ty && a[1]-1 == tx) return;
				q.offer(new int[] {a[0]-2, a[1]-1});
			}
			if (a[0] - 2 >= 0 && a[1] + 1 < l && !visited[a[0]-2][a[1]+1]) {
				visited[a[0]-2][a[1]+1] = true;
				dist[a[0]-2][a[1]+1] = dist[a[0]][a[1]] + 1;
				if (a[0]-2 == ty && a[1]+1 == tx) return;
				q.offer(new int[] {a[0]-2, a[1]+1});
			}
			if (a[0] + 2 < l && a[1] - 1 >= 0 && !visited[a[0]+2][a[1]-1]) {
				visited[a[0]+2][a[1]-1] = true;
				dist[a[0]+2][a[1]-1] = dist[a[0]][a[1]] + 1;
				if (a[0]+2 == ty && a[1]-1 == tx) return;
				q.offer(new int[] {a[0]+2, a[1]-1});
			}
			if (a[0] + 2 < l && a[1] + 1 < l && !visited[a[0]+2][a[1]+1]) {
				visited[a[0]+2][a[1]+1] = true;
				dist[a[0]+2][a[1]+1] = dist[a[0]][a[1]] + 1;
				if (a[0]+2 == ty && a[1]+1 == tx) return;
				q.offer(new int[] {a[0]+2, a[1]+1});
			}
			if (a[0] + 1 < l && a[1] - 2 >= 0 && !visited[a[0]+1][a[1]-2]) {
				visited[a[0]+1][a[1]-2] = true;
				dist[a[0]+1][a[1]-2] = dist[a[0]][a[1]] + 1;
				if (a[0]+1 == ty && a[1]-2 == tx) return;
				q.offer(new int[] {a[0]+1, a[1]-2});
			}
			if (a[0] - 1 >= 0 && a[1] - 2 >= 0 && !visited[a[0]-1][a[1]-2]) {
				visited[a[0]-1][a[1]-2] = true;
				dist[a[0]-1][a[1]-2] = dist[a[0]][a[1]] + 1;
				if (a[0]-1 == ty && a[1]-2 == tx) return;
				q.offer(new int[] {a[0]-1, a[1]-2});
			}
			if (a[0] + 1 < l && a[1] + 2 < l && !visited[a[0]+1][a[1]+2]) {
				visited[a[0]+1][a[1]+2] = true;
				dist[a[0]+1][a[1]+2] = dist[a[0]][a[1]] + 1;
				if (a[0]+1 == ty && a[1]+2 == tx) return; 
				q.offer(new int[] {a[0]+1, a[1]+2});
			}
			if (a[0] - 1 >= 0 && a[1] + 2 < l && !visited[a[0]-1][a[1]+2]) {
				visited[a[0]-1][a[1]+2] = true;
				dist[a[0]-1][a[1]+2] = dist[a[0]][a[1]] + 1;
				if (a[0]-1 == ty && a[1]+2 == tx) return;
				q.offer(new int[] {a[0]-1, a[1]+2});
			}
		}
	}

}
