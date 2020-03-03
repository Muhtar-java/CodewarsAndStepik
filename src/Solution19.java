import java.util.ArrayList;
import java.util.Collections;

public class Solution19 {

        public static long nextBiggerNumber(long n) {
            {
                ArrayList<Long> l = new ArrayList<>();
                while(n > 0){
                    l.add(n%10);
                    n /= 10;
                }
                long swap = -1, z = -1, sum1 = 0, sum2 = 0;
                for(int i = 0; i < l.size() - 1; i++)
                    if (l.get(i) > l.get(i + 1)) {
                        z = i + 1;
                        break;
                    }
                //System.out.println(z);
                if(z == -1)
                    return z;
                else {
                    sum1 = Sum(l,z);
                    //System.out.println(sum1);
                    for (int i = 0; i <= z; i++)
                        for (int d = i; d <= z; d++)
                            if (l.get(i) < l.get(d))
                                Collections.swap(l, i, d);
                    //System.out.println(Sum(l,z));
                    for(int i = (int)z - 1; i >= 0; i--){
                        Collections.swap(l, (int) z,i);
                        sum2 = Sum(l,z);
                        //System.out.println(sum2);
                        if(sum1 < sum2)
                            break;
                    }
                }
                return Sum(l,l.size() - 1);
            }
        }
        public static long Sum(ArrayList<Long> l,long z){
            long sum = 0;
            for (int i = 0; i <= z; i++)
                sum += l.get(i) * Math.pow(10, i);
            return sum;
        }

    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(1234567890));
        System.out.println(nextBiggerNumber(12));
        System.out.println(nextBiggerNumber(513));
        System.out.println(nextBiggerNumber(2017));
        System.out.println(nextBiggerNumber(111));
    }
}
