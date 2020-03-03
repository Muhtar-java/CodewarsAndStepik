import java.util.ArrayList;

public class Solution15 {

        public static long[] productFib(long prod) {
            ArrayList<Long> a = new ArrayList<>();
            a.add(0L);
            a.add(1L);
            long sum = a.get(0) * a.get(1), b;
            while(prod >= sum){
                b = a.get(0) + a.get(1);
                a.set(0, a.get(1));
                a.set(1, b);
                sum = a.get(0) * a.get(1);
            }
            long[] l;
            if(prod == sum){
                l = new long[]{a.get(0), a.get(1), 1};
                return l;
            }
            l = new long[]{a.get(0), a.get(1), 0};
            return l;
        }
}
