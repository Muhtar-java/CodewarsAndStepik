import java.util.ArrayList;

public class Solution14 {

        public static long[] gap(int g, long m, long n) {
            ArrayList<Long> l = new ArrayList<>();
            for (long i = m; i <= n; i++)
                if (isPrime(i))
                    l.add(i);
                for (int i = 1; i < l.size(); i++) {
                    if ((l.get(i) - l.get(i - 1)) != g) {
                        System.out.println(l.get(i-1));
                        l.remove(i - 1);
                        i--;
                    } else
                        break;
                }
                long[] a = new long[2];
                if(l.size() != 0){ a[0] = l.get(0); a[1] = l.get(1); }
                return a;
            }

            public static boolean isPrime(long n){
                for (int i = 2; i <= Math.sqrt(n); i++)
                    if (n % i == 0)
                        return false;
                return true;
            }

    public static void main(String[] args) {
            //long[] l = gap(2,100,110);
        //long[] f = gap(4,100,110);
        long[] d = gap(8,300,400);
        //long[] s = gap(10,100,110);
            //for(long a: l)
              //  System.out.println(a);
        for(long a: d)
            System.out.println(a);
        /*for(long a: d)
            System.out.println(a);
        for(long a: s)
            System.out.println(a);*/
    }
}
