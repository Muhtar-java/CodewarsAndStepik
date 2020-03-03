public class Solution23 {
    static boolean pathFinder(String maze) {
        String[] maze1 = maze.split("\n");
        char[][] m = new char[maze1.length][maze1.length];
        for(int i = 0; i < maze1.length; i++)
            for(int k = 0; k < maze1[i].length(); k++)
              m[i][k] = maze1[i].charAt(k);
        return isTrue(m,0,0,maze1);
    }
    static boolean isTrue(char[][] m,int i,int k,String[] maze){
        boolean first = false, second = false, third = false, forth = false;
        if(i == maze.length - 1 && k == maze[i].length() - 1)
            return true;
        if(k < m.length - 1 && m[i][k+1] == '.') {
            m[i][k] = '*';
            first = isTrue(m, i, k + 1,maze);
        }
        if(i < m.length - 1 && m[i+1][k] == '.') {
            m[i][k] = '*';
            second = isTrue(m, i + 1, k,maze);
        }
        if(i > 0 && m[i-1][k] == '.') {
            m[i][k] = '*';
            third = isTrue(m, i - 1, k,maze);
        }
        if(k > 0 && m[i][k-1] == '.') {
            m[i][k] = '*';
            forth = isTrue(m, i, k - 1,maze);
        }
        return (first||second||third||forth);
    }

    public static void main(String[] args) {
        String a =(".\n"+
                "..\n"+
                "W.\n"+
                "...\n"+
                "W..\n"+
                "W..\n"+
                "....\n"+
                ".WW.\n"+
                "...W\n"+
                ".W..\n");
        String b =(".W...\n"+
                ".W...\n"+
                ".W.W.\n"+
                "...W.\n"+
                "...W.\n");
        String c = ".W.\n"+
                ".W.\n"+
                "...";
        System.out.println(pathFinder(c));
    }
}
