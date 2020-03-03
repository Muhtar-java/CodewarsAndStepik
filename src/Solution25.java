import java.math.BigInteger;
import java.util.ArrayList;

public class Solution25 {
    public static BigInteger differentiate(String equation, long x) {
        if(!equation.contains("x"))
            return BigInteger.valueOf(0);
        ArrayList<BigInteger> bg = new ArrayList<>();
        BigInteger sum = new BigInteger("0");
        char[] a = equation.toCharArray();
        StringBuilder coe = new StringBuilder();
        StringBuilder pow = new StringBuilder();
        for(int i = 0; i < a.length; i++)
            switch(a[i]){
                case 'x': if(i > 0 && (a[i-1] == '-' || a[i-1] == '+')) {coe.append("1x"); if(i < a.length - 1 && a[i+1] != '^') pow.append('1');}
                            else if(i == 0) coe.append("1x");
                            else if(i < a.length - 1 && a[i+1] != '^') { pow.append('1'); coe.append('x');}
                            else coe.append('x'); break;
                case '^': if(i < a.length - 2) while(a[i+1] != '+' && a[i+1] != '-') { pow.append(a[i+1] + " "); i++;}
                            else pow.append(a[a.length - 1]);
                            break;
                default: coe.append(a[i]); break;
            }
        if(coe.charAt(coe.length() - 1) == 'x') {
            coe.append("+0");
            pow.append('1');
        }
        System.out.println(coe);
        System.out.println(pow);
        String[] nums = coe.toString().split("x");
        String[] pows = pow.toString().split(" ");
        for(int i = 0; i < pows.length; i++) {
            bg.add(i, BigInteger.valueOf(Long.parseLong(nums[i])));
            bg.set(i, bg.get(i).multiply(BigInteger.valueOf(Long.parseLong(pows[i]))));
            pows[i] = String.valueOf(Long.parseLong(pows[i]) - 1);
        }
        for(BigInteger k : bg)
            System.out.println(k);
        for(int i = 0; i < pows.length; i++)
            sum = sum.add(bg.get(i).multiply(BigInteger.valueOf(x).pow(Integer.parseInt(pows[i]))));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(differentiate("-x+50",7042));
    }
}
