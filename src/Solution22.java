import java.util.ArrayList;
import java.util.Comparator;

public class Solution22 {
    public static long hamming(int n) {
        ArrayList<Long> l = new ArrayList<>();
        for(int i = 0; i < 18; i++)
            for(int k = 0; k < 26; k++)
                for(int m = 0; m < 40; m++)
                    if((long)Math.pow(5,i)* (long)Math.pow(3,k)*(long)Math.pow(2,m) > 0)
                        l.add((long)Math.pow(5,i)* (long)Math.pow(3,k)*(long)Math.pow(2,m));
        l.sort(Comparator.naturalOrder());
        return l.get(n-1);
    }

    public static void main(String[] args) {
        System.out.println(hamming(5000));
    }
}
