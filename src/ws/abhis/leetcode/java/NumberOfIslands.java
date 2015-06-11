package ws.abhis.leetcode.java;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {
    private char[][] g;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        g=grid;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<g.length; i++) {
            for (int j=0; j<g[0].length; j++) {
                visited[i][j] = false;
            }
        }
        this.visited = visited;

        int islands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    conquer(i,j);
                }
            }
        }

        return islands;
    }

    private void conquer(int row, int col) {

        visited[row][col] = true;
        if (row > 0 && !visited[row-1][col] && g[row-1][col] == '1') {
            conquer(row-1, col);
        }

        if (row < g.length-1 && !visited[row+1][col] && g[row+1][col] == '1') {
            conquer(row+1, col);
        }

        if (col > 0 && !visited[row][col-1] && g[row][col-1] == '1') {
            conquer(row, col-1);
        }

        if (col < g[0].length-1 && !visited[row][col + 1] && g[row][col+1] == '1') {
            conquer(row, col+1);
        }

    }

    public static void main(String... args) {

//        char[][] a = new char[4][5];
//        a[0] = new char[]{'1', '1', '1', '1', '0'};
//        a[1] = new char[]{'1','1','0','1','0'};
//        a[2] = new char[]{'1','1','0','0','0'};
//        a[3] = new char[]{'0','0','0','0','0'};

        char[][] a = new char[3][3];
        a[0] = new char[] {'1','1','1'};
        a[1] = new char[] {'0','1','0'};
        a[2] = new char[] {'0', '1', '0'};



        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(a));
    }
}
