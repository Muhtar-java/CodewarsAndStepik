import java.math.BigInteger;

public class Solution16 {
        public static BigInteger perimeter(BigInteger n) {
            BigInteger l = new BigInteger("1");
            BigInteger k = new BigInteger("1");
            BigInteger i = new BigInteger("1");
            BigInteger p;
            BigInteger sum = new BigInteger("0");
            n = n.add(BigInteger.valueOf(1));
            while(n.compareTo(i) != -1)
            {
                i = i.add(BigInteger.valueOf(1));
                p = l;
                sum = sum.add(k);
                l = l.add(k);
                k = p;
                System.out.println(sum);
            }
            sum = sum.multiply(BigInteger.valueOf(4));
            return sum;
        }

    public static void main(String[] args) {
        BigInteger l = new BigInteger("7");
        System.out.println(perimeter(l));
    }
}
