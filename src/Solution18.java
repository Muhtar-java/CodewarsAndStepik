import java.math.BigInteger;

public class Solution18 {
        public static long findNb(long m) {
            long sum = 1;
            BigInteger a = new BigInteger("1");
            BigInteger l = new BigInteger(String.valueOf(m));
            while(l.compareTo(a) > -1){
                if(l.compareTo(a) == 0)
                    return sum;
                sum++;
                System.out.println(a);
                a = a.add(BigInteger.valueOf((long) Math.pow(sum,3)));
            }
            return -1;
        }

    public static void main(String[] args) {
        System.out.println(findNb(4183059834009L));
    }
}
