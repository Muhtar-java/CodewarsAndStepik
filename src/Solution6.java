import java.util.HashMap;

public class Solution6 {
        public static String orderWeight(String strng) {
            String[] s = strng.split(" ");
            if(s.length == 1)
                return strng;
            String g;
            int p = 0;
            char[] ch = new char[100];
            char[] sh = new char[100];
            for (int i = 0; i < s.length; i++)
                for (int d = i + 1; d < s.length; d++) {
                    if (sum(Long.parseLong(s[i])) > sum(Long.parseLong(s[d]))) {
                        g = s[i];
                        s[i] = s[d];
                        s[d] = g;
                    } else if (sum(Long.parseLong(s[i])) == sum(Long.parseLong(s[d]))) {
                        if(s[i].compareTo(s[d]) > -1) {
                            g = s[i];
                            s[i] = s[d];
                            s[d] = g;
                        }
                    }
                }
            StringBuilder sb = new StringBuilder();
            for(String c: s)
                sb.append(c).append(" ");
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        public static long sum (long a){
            long s = 0;
            while(a > 0){
                s += a%10;
                a /= 10;
            }
            return s;
        }

    public static void main(String[] args) {
        String s = "424726 392632 91654 144926 218924 174933 464942 397109 396129 433768 375808";
        System.out.println(orderWeight("59544965313"));
    }
}
