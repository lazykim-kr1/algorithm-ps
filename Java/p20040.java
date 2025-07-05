import java.util.Scanner;

public class p20040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] parent = new int[n];
        int[] size = new int[n];

        int rslt = 0;
        boolean updated = false;
        boolean cycle = false;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            int a =  sc.nextInt();
            int b = sc.nextInt();

            if (find(a, parent) == find(b, parent)) {
                cycle = true;
                if (!updated) {
                    rslt = i+1;
                    updated = true;
                }
            } else {
                union(a, b, parent, size);
            }
        }


        if (cycle) {
            System.out.println(rslt);
        } else {
            System.out.println(0);
        }

    }

    public static int find(int k, int[] parent) {
        if (parent[k] != k) {
            parent[k] = find(parent[k], parent);
        }
        return parent[k];
    }

    public static void union(int x, int y, int[] parent, int[] size) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}
