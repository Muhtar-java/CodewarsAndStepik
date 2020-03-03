import java.util.ArrayList;
import java.util.Arrays;

public class Solution28 {
    private int[][] gr;

    public Solution28(int[][] grid){
        gr = grid;
    }

    public int[][] solve(){
        ArrayList<Integer> col = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        for(int i = 0; i < 9; i++)
            for(int k = 0; k < 9; k++)
                if(gr[i][k] == 0){
                    col.add(i);
                    row.add(k);
                }
        if(solve_s(col,row,0))
            return gr;
        return gr;
    }

    public boolean solve_s(ArrayList<Integer> o, ArrayList<Integer> p, int i) {
        int row = o.get(i);
        int col = p.get(i);
        i++;
        if (i == o.size())
            return true;
            for (int k = 1; k < 10; k++) {
                if (isempty(gr, col, row, k) && boxempty(gr, col - col % 3, row - row % 3, k)) {
                    gr[col][row] = k;
                    if (solve_s(o,p,i))
                        return true;
                    gr[col][row] = 0;
                }
            }
            return false;
    }

    public boolean boxempty(int [][] g, int startc, int startr, int k){
        for(int i = 0; i < 3; i++)
            for(int l = 0; l < 3; l++)
                if(g[i + startc][l + startr] == k)
                    return false;
        return true;
    }

    public boolean isempty(int[][] g,int m, int n, int k){
        for(int i = 0; i < g.length; i++)
            if(g[m][i] == k)
                return false;
        for(int i = 0; i < g.length; i++)
            if(g[i][n] == k)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 6, 1, 0, 0, 0, 0, 8},
                {0, 8, 0, 0, 9, 0, 0, 3, 0},
                {2, 0, 0, 0, 0, 5, 4, 0, 0},
                {4, 0, 0, 0, 0, 1, 8, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 4, 0},
                {0, 0, 7, 9, 0, 0, 0, 0, 3},
                {0, 0, 8, 4, 0, 0, 0, 0, 6},
                {0, 2, 0, 0, 5, 0, 0, 8, 0},
                {1, 0, 0, 0, 0, 2, 5, 0, 0}};
        Solution28 solv = new Solution28(grid);
        grid = solv.solve();
        for(int[] i : grid)
            System.out.println(Arrays.toString(i));
    }
}
