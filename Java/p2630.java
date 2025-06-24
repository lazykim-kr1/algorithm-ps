import java.util.Scanner;

public class p2630 {
	
	static int blue = 0;
	static int white = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		int N = sc.nextInt();
		int[][] list = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				list[i][j] = sc.nextInt();
			}
		}
		dnq(list, 1, N, 1, N);
		
		System.out.println(white);
		System.out.println(blue);
		sc.close();
	}
	
	
	
	public static void dnq(int[][] list, int xf, int xl, int yf, int yl) {
		int first = list[yf][xf];
		
		if (xl == xf && yl == yf) {
			if (first == 1) blue++;
			if (first == 0) white++;
			return;
		}

		for (int i = yf; i <= yl; i++) {
			for (int j = xf; j <= xl; j++) {
				if (first != list[i][j]) {
					dnq(list, xf, (xf + xl) / 2, yf, (yf + yl) / 2);
					dnq(list, (xf + xl) / 2 + 1, xl, yf, (yf + yl) / 2);
					dnq(list, xf, (xf + xl) / 2, (yf + yl) / 2 + 1, yl);
					dnq(list, (xf + xl) / 2 + 1, xl, (yf + yl) / 2 + 1, yl);
					return;
				}
			}
		}
		if (first == 1) blue++;
		if (first == 0) white++;
		return;
	}
}
