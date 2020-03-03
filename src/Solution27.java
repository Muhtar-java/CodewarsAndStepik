import java.util.Arrays;

public class Solution27 {

    private int[][] grid = new int[9][9];
    private int[][] solved = new int[9][9];
    private int[][] solved2 = new int[9][9];
    private int colu = 0;
    private int ro = 0;

        public Solution27(int[][] grid) {
            if(grid.length != this.grid.length)
                throw new IllegalArgumentException("Stupid!");
            else
                for(int[] l: grid)
                    if(l.length != 9)
                        throw new IllegalArgumentException("Stupid!");
            this.grid = grid;
            solved2 = grid;
        }

        public int[][] solve() {
            solve_s();
            solved = grid;
            grid = solved2;
            System.out.println(Arrays.deepToString(solved));
            if(!solve_s())
                return grid;
            throw new IllegalArgumentException("Illegal");
        }

        public boolean solve_s(){
            int row = getemr(grid);
            int col = getemc(grid);
            if(getemc(grid) == 9 && getemr(grid) == 9) {
                if (!Arrays.deepEquals(grid, solved))
                    return true;
                else
                    row = ro;
                    col = colu;
            }
                for (int i = 1; i < 10; i++) {
                        if (isempty(grid, col, row, i) && boxempty(grid, col - col % 3, row - row % 3, i)) {
                            grid[col][row] = i;
                        if (solve_s())
                            return true;
                        grid[col][row] = 0;
                    }
                }
            return false;
        }

        public boolean isempty(int[][] g,int m, int n, int k){
            for(int i = 0; i < g.length; i++)
                if(g[m][i] == k || k == solved[m][n])
                    return false;
            for(int i = 0; i < g.length; i++)
                if(g[i][n] == k || k == solved[m][n])
                    return false;
            return true;
        }
        public boolean boxempty(int [][] g, int startc, int startr, int k){
            for(int i = 0; i < 3; i++)
                for(int l = 0; l < 3; l++)
                    if(g[i + startc][l + startr] == k)
                        return false;
            return true;
        }
        public int getemc(int[][] g){
            for(int i = 0; i < 9; i++)
                for(int k = 0; k < 9; k++)
                    if(g[i][k] == 0){
                        colu = i;
                        return i;}
            return 9;
        }
        public int getemr(int[][] g){
            for(int i = 0; i < 9; i++)
                for(int k = 0; k < 9; k++)
                    if(g[i][k] == 0){
                        ro = k;
                        return k;}
            return 9;
    }

    public static void main(String[] args) {
        int[][] puzzle   = {{0, 0, 6, 1, 0, 0, 0, 0, 8},
                {0, 8, 0, 0, 9, 0, 0, 3, 0},
                {2, 0, 0, 0, 0, 5, 4, 0, 0},
                {4, 0, 0, 0, 0, 1, 8, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 4, 0},
                {0, 0, 7, 9, 0, 0, 0, 0, 3},
                {0, 0, 8, 4, 0, 0, 0, 0, 6},
                {0, 2, 0, 0, 5, 0, 0, 8, 0},
                {1, 0, 0, 0, 0, 2, 5, 0, 0}};
        int[][] puzzle2 = {{3, 4, 7, 9, 0, 0, 0, 8, 0},
                {0, 1, 0, 8, 0, 0, 0, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 8},
                {0, 0, 0, 4, 0, 8, 0, 0, 0},
                {6, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 7, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 0, 5, 0, 3, 0},
                {0, 5, 0, 0, 0, 4, 2, 7, 9}};
        int[][] inval = {{1, 1, 3, 4, 5, 6, 7, 8, 9},
        {4, 0, 6, 7, 8, 9, 1, 2, 3},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {2, 3, 4, 5, 6, 7, 8, 9},
        {5, 6, 7, 8, 9, 1, 2, 3, 4},
        {8, 9, 1, 2, 3, 4, 5, 6, 7},
        {3, 4, 5, 6, 7, 8, 9, 1, 2},
        {6, 7, 8, 9, 1, 2, 3, 4, 5},
        {9, 1, 2, 3, 4, 5, 6, 7, 8},
        {1, 1, 3, 4, 5, 6, 7, 8, 9},
        {4, 0, 6, 7, 8, 9, 1, 2, 3},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {2, 3, 4, 5, 6, 7, 8, 9, 1},
        {5, 6, 7, 8, 9, 1, 2, 3, 4},
        {8, 9, 1, 2, 3, 4, 5, 6, 7},
        {3, 4, 5, 6, 7, 8, 9, 1, 2},
        {6, 7, 8, 9, 1, 2, 3, 4, 5},
        {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        puzzle2 = new Solution27(puzzle2).solve();
        for(int [] l : puzzle2)
            System.out.println(Arrays.toString(l));
    }
}
