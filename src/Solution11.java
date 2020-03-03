public class Solution11 {

        int rank = -8;
        int progress = 0;
        public Solution11() throws IllegalArgumentException{
            if(rank > 8 || rank < -8){
                throw new IllegalArgumentException("illegal argument");
            }
        }
        public void incProgress(int prog){
            if(rank > 8 || rank < -8 || prog > 8 || prog < -8){
                throw new IllegalArgumentException("illegal argument");
            }
            if(prog == rank)
                progress += 3;
            else if(prog < 0 && rank > 0 && (rank - prog - 1) == 1)
                progress += 1;
            else if ((rank - prog) == 1)
                progress += 1;
            else if((rank - prog) < 0)
                    if(prog > 0 && rank < 0)
                        progress += 10 * ((rank - prog)+1) * ((rank - prog)+1);
                    else
                        progress += 10 * (rank - prog) * (rank - prog);
            while(progress >= 100){
                rank++;
                if(rank == 0)
                    rank++;
                progress -= 100;
            }
        }

    public static void main(String[] args) {
        Solution11 a = new Solution11();
        a.rank = 1;
        a.incProgress(-1);
        System.out.println(a.rank+" "+a.progress);
        System.out.println(a.rank+" "+a.progress);
    }
}
