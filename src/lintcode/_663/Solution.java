package lintcode._663;

public class Solution {

    public void wallsAndGates(int[][] rooms) {
        // write your code here
        int rows = rooms.length;
        if (rows == 0){
            return;
        }
        int cols = rooms[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0){
                    dfs(rooms, i, j ,0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int val){
        if (i<0 || i>=rooms.length || j < 0 || j>=rooms[0].length || val > rooms[i][j]){
            return;
        }
        rooms[i][j] = val;
        dfs(rooms, i+1, j, val+1);
        dfs(rooms, i-1, j, val+1);
        dfs(rooms, i, j+1, val+1);
        dfs(rooms, i, j-1, val+1);
    }
}
