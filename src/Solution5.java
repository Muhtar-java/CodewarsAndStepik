import java.math.BigDecimal;

public class Solution5 {
        public static long findNb(long m) {
            BigDecimal a = BigDecimal.valueOf(1);
            BigDecimal sum = BigDecimal.valueOf(1);
            while(m >= a.longValue()){
                if(m == a.longValue())
                    return sum.longValue();
                sum.add(BigDecimal.valueOf(1));
                a.add(BigDecimal.valueOf(Math.pow(sum.longValue(),3)));
            }
            return -1;
        }

    public static void main(String[] args) {
        long a = 4183059834009L;
        System.out.println(findNb(a));
        int b = 10, sum = 2;
        System.out.println(Math.pow(b,sum));
    }
}
