
public class Solution12 {

        public static int determinant(int[][] matrix) {
            int sum = 0, s = 1;
            if(matrix.length == 2)
                return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
            for (int i = 0; i < matrix.length; i++) {
                sum += matrix[i][0] * s *determinant(minor(matrix,i));
                s *= -1;
            }
            return sum;
        }

        public static int[][] minor(int[][] m, int n){
            int b = 0,d = 0;
            int[][] a = new int[m.length -1][m.length-1];
            for(int i = 0; i < m.length; i ++)
                for(int c = 0; c < m.length; c ++)
                    if( i!=n && c!=0) {
                        a[b][d] = m[i][c];
                        if (d < a.length - 1){
                            d++;}
                        else if(b < a.length - 1) {
                            d = 0;
                            b++;
                        }
                    }
            return a;
        }

    public static void main(String[] args) {
        int [][] a = {{1,4,3,2,1}, {2,2,3,4,2},{1,3,2,2,4},{3,3,4,4,2},{2,1,3,2,3}};
        System.out.println(determinant(a));
    }
}
