package leetcode._684;

public class Solution {

    class UF{

        int[] ancestor;

        public UF(int n) {
            ancestor = new int[n];
            for (int i = 0; i < n; i++) {
                ancestor[i] = i;
            }
        }
        public void merge(int index1, int index2) {
            ancestor[find(index1)] = find(index2);
        }

        public int find(int index) {
            if (ancestor[index] != index) {
                ancestor[index] = find(ancestor[index]);
            }
            return ancestor[index];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int rows = edges.length;
        UF uf = new UF(rows);
        int[] res= new int[2];
        for (int i = 0; i < rows; i++) {
            int index1 = edges[i][0] - 1;
            int index2 = edges[i][1] - 1;
            if (uf.find(index1) == uf.find(index2)) {
                res[0] = index1;
                res[1] = index2;
                return res;
            }else {
                uf.merge(index1, index2);
            }
        }
        return res;
    }

}
