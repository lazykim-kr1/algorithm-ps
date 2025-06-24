import java.util.Scanner;

public class p1992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[][] list = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			
			for (int j = 1; j <= N; j++) {
				list[i][j] = str.charAt(j-1) - '0';
			}
		}
		dnq(list, 1, 1, N, N);
		sc.close();
	}
	
	public static void dnq(int[][] list, int xf, int yf, int xl, int yl) {
		int first = list[yf][xf];
		
		if (xl == xf && yl == yf) {
			System.out.print(first);
			return;
		}
		
		for (int i = yf; i <= yl; i++) {
			for (int j = xf; j <= xl; j++) {
				if (list[i][j] != first) {
					System.out.print("(");
					dnq(list, xf, yf, (xf + xl) / 2, (yf + yl) / 2);
					dnq(list, (xf + xl) / 2 + 1, yf, xl, (yf + yl) / 2);
					dnq(list, xf, (yf + yl) / 2 + 1, (xf + xl) / 2, yl);
					dnq(list, (xf + xl) / 2 + 1, (yf + yl) / 2 + 1, xl, yl);
					System.out.print(")");
					return;
				}
			}
		}
		System.out.print(first);
		return;
	}
}
