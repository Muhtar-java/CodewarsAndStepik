import java.util.ArrayList;
import java.util.List;

public class Solution9 {
        public static List<Long> sumDigPow(long a, long b) {
            List<Long> list = new ArrayList<>();
            ArrayList<Long> l = new ArrayList<>();
            long c = a;
            while(a < b){
                while(c > 0){
                    l.add(c % 10);
                    c /= 10;
                }
                if(a == sum(l))
                    list.add(a);
                a++;
                l.clear();
                c = a;
            }
            return list;
        }
        public static Long sum(List<Long> a){
            long suma = 0, s = 1;
            for(int i = a.size() - 1; i >= 0; i--){
                suma += Math.pow(a.get(i),s);
                s++;
            }
            return suma;
        }

    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 100));
    }
}
