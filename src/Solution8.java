import java.util.ArrayList;

public class Solution8 {
        public static String WhoIsNext(String[] names, int n)
        {
            double p = 0, sum = 0, g = 5, k = 0;
            int m = -1;
            while(p < n){
                p += g;
                g *= 2;
                k = Math.pow(2,sum);
                sum++;
            }
            g /= 2;
            p -= g;
            System.out.println(k);
            while(p < n){
                p += k;
                System.out.println(p);
                m++;
            }
            return names[m];
        }

    public static void main(String[] args) {
        String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
        int n = 1;
        System.out.println(WhoIsNext(names,n));
    }
}
